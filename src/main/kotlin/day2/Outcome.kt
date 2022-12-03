package day2

enum class Outcome(val score: Int, val encoded: Char) {
    LOSE(0, 'X'),
    DRAW(3, 'Y'),
    WIN(6, 'Z');
}

fun decodeOutcome(encoded: Char): Outcome =
    Outcome.values().find { it.encoded == encoded }!!