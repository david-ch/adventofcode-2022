package day2

enum class Shape(val encoded: Char, val encodedMine: Char, val winnerIdx: Int, val loserIdx: Int) {
    ROCK('A', 'X', 1, 2),
    PAPER('B', 'Y', 2, 0),
    SCISSORS('C', 'Z', 0, 1);

    fun winner(): Shape = Shape.values()[this.winnerIdx]

    fun loser(): Shape = Shape.values()[this.loserIdx]
}

fun decodeShape(encoded: Char): Shape =
    Shape.values().find { it.encoded == encoded }!!

fun decodeMyShape(encoded: Char): Shape =
    Shape.values().find { it.encodedMine == encoded }!!
