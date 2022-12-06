package day5

import readLines
import java.util.LinkedList
import kotlin.math.ceil
import kotlin.streams.asSequence

object Day5 {

    fun solvePart1(): String {
        val stacks = readCrateStacks()

        readInstructions().forEach { instruction ->
            repeat(instruction.itemsNum) {
                stacks[instruction.toStack].push(stacks[instruction.fromStack].pop())
            }
        }

        return getTopCrates(stacks)
    }

    fun solvePart2(): String {
        val stacks = readCrateStacks()

        readInstructions().forEach { instruction ->
            val tempStack = LinkedList<Char>()

            repeat(instruction.itemsNum) {
                tempStack.push(stacks[instruction.fromStack].pop())
            }

            repeat(instruction.itemsNum) {
                stacks[instruction.toStack].push(tempStack.pop())
            }
        }

        return getTopCrates(stacks)
    }

    private fun readCrateStacks(): Array<LinkedList<Char>> {
        val stackLines = readLines("/day5/input")
            .takeWhile { !it.startsWith(" 1") }
            .map { readStacksLine(it) }
            .toList()

        val stacks = Array(stackLines[0].size) { LinkedList<Char>() }

        stackLines
            .reversed()
            .forEach {
                it.forEachIndexed { i, item -> if (item != ' ') stacks[i].push(item) }
            }

        return stacks
    }

    private fun readStacksLine(line: String): Array<Char> {
        val result = Array(ceil(line.length / 4.0).toInt()) { ' ' }

        for (i in 0..result.lastIndex) {
            result[i] = line[i * 4 + 1]
        }

        return result
    }

    private fun readInstructions(): List<Instruction> =
        readLines("/day5/input")
            .asSequence()
            .filter { it.startsWith("move") }
            .map { parseInstruction(it) }
            .toList()

    private fun parseInstruction(instruction: String): Instruction =
        instruction.split(" ")
            .let { Instruction(it[1].toInt(), it[3].toInt() - 1, it[5].toInt() - 1) }

    private fun getTopCrates(stacks: Array<LinkedList<Char>>): String =
        stacks.map { it.pop() }.joinToString("")

    private data class Instruction(val itemsNum: Int, val fromStack: Int, val toStack: Int)
}