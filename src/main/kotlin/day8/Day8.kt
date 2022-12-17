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