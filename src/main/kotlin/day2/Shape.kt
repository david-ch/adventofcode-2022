package day2

import day2.Shape.*

enum class Shape(val score: Int, val winnerIdx: Int, val loserIdx: Int) {
    ROCK(1, 1, 2),
    PAPER(2, 2, 0),
    SCISSORS(3, 0, 1)
}

fun decodeShape(encoded: Char): Shape = when (encoded) {
    'A' -> ROCK
    'B' -> PAPER
    else -> SCISSORS
}

fun decodeMyShapeForPart1(encoded: Char): Shape = when (encoded) {
    'X' -> ROCK
    'Y' -> PAPER
    else -> SCISSORS
}