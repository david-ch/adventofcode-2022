package day2

import readLines

private const val INPUT_FILE = "/day2/input"

object Day2 {

    fun solvePart1(): Int = readLines(INPUT_FILE)
        .mapToInt {
            calculateScore(
                decodeShape(it[0]),
                decodeMyShapeForPart1(it[2])
            )
        }
        .sum()

    fun solvePart2(): Int = readLines(INPUT_FILE)
        .mapToInt {
            val their = decodeShape(it[0])

            calculateScore(
                their,
                selectMine(their, decodeOutcome(it[2]))
            )
        }
        .sum()

    private fun calculateScore(their: Shape, mine: Shape): Int =
        mine.score + play(their, mine).score
}
