package day2

import day2.Outcome.*

enum class Outcome(val score: Int) {
    LOSE(0),
    DRAW(3),
    WIN(6);
}

fun decodeOutcome(encoded: Char): Outcome = when (encoded) {
    'X' -> LOSE
    'Y' -> DRAW
    else -> WIN
}