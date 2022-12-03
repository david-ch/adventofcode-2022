package day2

import day2.Outcome.*
import readLines

object Day2 {

    fun solvePart1(): Int = readLines("/day2/input")
        .mapToInt { calculateScore(decodeShape(it[0]), decodeMyShape(it[2])) }
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

    private fun selectMine(their: Shape, desiredOutcome: Outcome): Shape = when (desiredOutcome) {
        LOSE -> their.loser()
        DRAW -> their
        WIN -> their.winner()
    }

    private fun calculateScore(their: Shape, mine: Shape): Int =
        (Shape.values().indexOf(mine) + 1) + findOutcome(their, mine).score

    private fun findOutcome(their: Shape, mine: Shape): Outcome = when (mine) {
        their -> DRAW
        their.winner() -> WIN
        else -> LOSE
    }
}
