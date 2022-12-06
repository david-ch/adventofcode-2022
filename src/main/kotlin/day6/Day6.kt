package day6

import readFile
import kotlin.streams.asSequence

private const val INPUT_FILE = "/day6/input"

object Day6 {

    fun solvePart1(): Int = findMarker(4)

    fun solvePart2(): Int = findMarker(14)

    private fun findMarker(markerLen: Int): Int {
        val lastN = ArrayDeque<Int>()

        readFile(INPUT_FILE)
            .chars()
            .asSequence()
            .forEachIndexed { i, ch ->
                lastN.addLast(ch)

                if (lastN.size > markerLen) {
                    lastN.removeFirst()
                }

                if (lastN.size == markerLen && lastN.toSet().size == markerLen) {
                    return i + 1
                }
            }

        throw IllegalArgumentException("Could not find the solution")
    }
}