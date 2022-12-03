package day2

import day2.Shape.*

enum class Shape(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
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