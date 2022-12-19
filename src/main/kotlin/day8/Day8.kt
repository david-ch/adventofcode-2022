package day8

import readLines
import java.lang.Integer.parseInt

object Day8 {

    fun solvePart1(): Int {
        val forest = readForest()
        val visibilityMap = initVisibilityMap(forest)
        scanForest(forest, visibilityMap)
        return visibilityMap.flatten().count { it }
    }

    fun solvePart2(): Int {
        val forest = readForest()

        var bestView = 0

        for (row in 0..forest.lastIndex) {
            for (col in 0..forest[row].lastIndex) {
                val right = scanDirectionViewingDistance(col..forest[row].lastIndex) { forest[row][it] }
                val left = scanDirectionViewingDistance(col downTo 0) { forest[row][it] }
                val down = scanDirectionViewingDistance(row..forest.lastIndex) { forest[it][col] }
                val up = scanDirectionViewingDistance(row downTo 0) { forest[it][col] }

                val score = right * left * down * up
                bestView = bestView.coerceAtLeast(score)
            }
        }

        return bestView
    }

    private fun scanDirectionViewingDistance(range: IntProgression, getTree: (idx: Int) -> Int): Int {
        val iter = range.iterator()
        val viewingTreeHeight = getTree(iter.nextInt())

        var count = 0
        while (iter.hasNext()) {
            count++
            if (getTree(iter.nextInt()) >= viewingTreeHeight) {
                return count
            }
        }

        return count
    }

    private fun initVisibilityMap(forest: List<List<Int>>) = Array(forest.size) {
        Array(forest[0].size) { false }
    }

    private fun readForest(): List<List<Int>> = readLines("/day8/input")
        .map { it.toCharArray() }
        .map { it.map { e -> parseInt(e.toString()) } }
        .toList()

    private fun scanForest(forest: List<List<Int>>, visibilityMap: Array<Array<Boolean>>) {
        for (row in 0..forest.lastIndex) {
            scanLine(
                0..forest[row].lastIndex,
                { forest[row][it] },
                { visibilityMap[row][it] = true }
            )
        }

        for (col in 0..forest.first().lastIndex) {
            scanLine(
                0..forest.lastIndex,
                { forest[it][col] },
                { visibilityMap[it][col] = true }
            )
        }
    }

    private fun scanLine(
        range: IntProgression,
        getTree: (idx: Int) -> Int,
        setVisible: (idx: Int) -> Unit
    ) {
        scanLineDirection(range, getTree, setVisible)
        scanLineDirection(range.reversed(), getTree, setVisible)
    }

    private fun scanLineDirection(
        range: IntProgression,
        getTree: (idx: Int) -> Int,
        setVisible: (idx: Int) -> Unit
    ) {
        var biggestTreeSoFar = -1
        range.forEach {
            val tree = getTree(it)
            if (tree > biggestTreeSoFar) {
                setVisible(it)
            }

            biggestTreeSoFar = biggestTreeSoFar.coerceAtLeast(tree)
        }
    }
}