package day10

import readLines
import java.lang.Integer.parseInt
import kotlin.streams.asSequence

object Day10 {

    fun solvePart1(): Int = readLines("/day10/input")
        .asSequence()
        .map { parseCommand(it) }
        .processUsing(Cpu(x = 1))
        .mapIndexed { idx, cpu -> measureSignalIfNeeded(idx, cpu) }
        .sum()

    fun solvePart2(): String =
        readLines("/day10/input")
        .asSequence()
        .map { parseCommand(it) }
        .processUsing(Cpu(x = 1))
        .fold(createScreen()) { screen, cpu ->
            screen.drawSprite(cpu.x)
            screen
        }
        .print()

    private fun measureSignalIfNeeded(idx: Int, cpu: Cpu): Int =
        if (listOf(20, 60, 100, 140, 180, 220).contains(idx + 1))
            signalStrength(idx, cpu)
        else 0

    private fun signalStrength(idx: Int, cpu: Cpu) = (idx + 1) * cpu.x

    private fun parseCommand(str: String): Command = when(str.substring(0, 4)) {
        "addx" -> AddxCommand(parseInt(str.substring(5)))
        "noop" -> NoopCommand()
        else -> throw IllegalArgumentException("Unsupported command type ${str.substring(0, 3)}")
    }
}