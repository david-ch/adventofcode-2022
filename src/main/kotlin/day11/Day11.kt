package day11

import readLines
import java.math.BigInteger
import kotlin.streams.asSequence

object Day11 {

    fun solvePart1(): BigInteger {
        var monkeys = readMonkeys()
        val manageWorry = reliefAfterEachTurn(reliefFactor = BigInteger.valueOf(3))

        repeat(20) {
            monkeys = playRound(monkeys, manageWorry)
        }

        return calculateMonkeyBusinessLevel(monkeys)
    }

    fun solvePart2(): BigInteger {
        var monkeys = readMonkeys()
        val manageWorry = manageRidiculousLevelsOfWorry(
            modulo = monkeys.map { it.logic.testDivisor }.reduce { a, b -> a * b }
        )

        repeat(10000) {
            monkeys = playRound(monkeys, manageWorry)
        }

        return calculateMonkeyBusinessLevel(monkeys)
    }

    private fun calculateMonkeyBusinessLevel(monkeys: List<Monkey>): BigInteger =
        monkeys
            .sortedByDescending { it.itemsInspected }
            .let { it[0].itemsInspected * it[1].itemsInspected }

    private fun readMonkeys() = readLines("/day11/input")
        .asSequence()
        .parseMonkeyNotes()
        .toList()

    private fun playRound(monkeys: List<Monkey>, manageWorry: ManageWorry): List<Monkey> {
        val monkeysCopy = monkeys.toMutableList()

        for (idx in 0..monkeysCopy.lastIndex) {
            val result = monkeysCopy[idx].playWithItems(manageWorry).throwItems()
            monkeysCopy[idx] = result.first

            result.second.forEach { monkeyThrowDecision ->
                monkeysCopy[monkeyThrowDecision.toMonkey] = monkeysCopy[monkeyThrowDecision.toMonkey].receive(monkeyThrowDecision.item)
            }
        }

        return monkeysCopy
    }
}