package day4

import readLines
import java.util.function.Predicate

private const val INPUT_FILE = "/day4/input"

object Day4 {

    fun solvePart1(): Long = countElves {
        it.first.contains(it.second) || it.second.contains(it.first)
    }

    fun solvePart2(): Long = countElves {
        it.first.overlaps(it.second)
    }

    private fun countElves(predicate: Predicate<Pair<IntRange, IntRange>>): Long =
        readLines(INPUT_FILE)
            .map { parseRanges(it) }
            .filter { predicate.test(it) }
            .count()

    private fun parseRanges(str: String): Pair<IntRange, IntRange> =
        str.split(",")
            .let { Pair(parseRange(it[0]), parseRange(it[1])) }

    private fun parseRange(str: String): IntRange =
        str.split("-")
            .let { IntRange(it[0].toInt(), it[1].toInt()) }

    private fun IntRange.contains(another: IntRange): Boolean =
        this.contains(another.first) && this.contains(another.last)

    private fun IntRange.overlaps(another: IntRange): Boolean =
        this.contains(another.first)
                || this.contains(another.last)
                || another.contains(this)
}