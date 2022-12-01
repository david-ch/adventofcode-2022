package day1

import java.util.*
import java.util.Comparator.reverseOrder


object Day1 {

    fun solvePart1(): Int = sumOfTop(1)

    fun solvePart2(): Int = sumOfTop(3)

    private fun sumOfTop(n: Int): Int {
        val maxValues = PriorityQueue<Int>(reverseOrder())

        var currentSum = 0
        readLines().forEach {
            if (it.isEmpty()) {
                maxValues.add(currentSum)
                currentSum = 0
            }
            else {
                currentSum += it.toInt()
            }
        }

        return maxValues.take(n).sum()
    }

    private fun readLines() = Day1::class.java.getResourceAsStream("/day1/input")!!
        .bufferedReader()
        .lines()
}
