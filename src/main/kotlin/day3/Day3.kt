package day3

import readLines
import kotlin.streams.asSequence

private const val INPUT_FILE = "/day3/input"

object Day3 {

    fun solvePart1(): Int = readLines(INPUT_FILE)
        .map { getCompartments(it) }
        .mapToInt { calculateDuplicatesPriority(it) }
        .sum()

    fun solvePart2(): Int = readLines(INPUT_FILE)
        .asSequence()
        .chunked(3)
        .map { findSingleCommonItem(it) }
        .map { getItemPriority(it) }
        .sum()

    private fun findSingleCommonItem(it: List<String>) =
        it.map { t -> indexItems(t) }
            .reduce { a, b -> a.intersection(b) }
            .getSingleIndexedItem()

    private fun getCompartments(rucksack: String): Pair<String, String> =
        Pair(
            rucksack.substring(0, rucksack.length / 2),
            rucksack.substring(rucksack.length / 2)
        )

    private fun calculateDuplicatesPriority(compartments: Pair<String, String>): Int {
        val firstCompartmentIdx = indexItems(compartments.first)

        return compartments.second.chars()
            .filter { firstCompartmentIdx.containsItem(it.toChar()) }
            .distinct()
            .map { getItemPriority(it.toChar()) }
            .sum()
    }

    private fun getItemPriority(item: Char): Int = when {
        item >= 'a' -> item - 'a' + 1
        else -> item - 'A' + 27
    }
}
