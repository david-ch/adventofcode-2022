package day2

import day2.Outcome.*
import readLines

object Day2 {

    fun solvePart1(): Int = readLines("/day2/input")
        .mapToInt {
            calculateScore(
                decodeShape(it[0]),
                decodeMyShapeForPart1(it[2])
            )
        }
        .sum()

    fun solvePart2(): Int = readLines("/day2/input")
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
