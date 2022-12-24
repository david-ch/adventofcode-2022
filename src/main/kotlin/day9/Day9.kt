package day9

import readLines
import kotlin.streams.asSequence


object Day9 {

    fun solvePart1(): Int = solveFor(length = 2)

    fun solvePart2(): Int = solveFor(length = 10)

    private fun solveFor(length: Int): Int = readLines("/day9/input")
        .asSequence()
        .map { parseCommand(it) }
        .flatMap { it.steps() }
        .fold(createTracedRope(length)) { rope, direction ->
            rope.move(direction.asMovement())
        }
        .trace
        .size

    enum class Direction {
        U, D, L, R;

        fun asMovement() = when(this) {
            L -> Movement(-1, 0)
            R -> Movement(1, 0)
            D -> Movement(0, 1)
            U -> Movement(0, -1)
        }
    }

    private data class Command(val direction: Direction, val stepsNum: Int) {

        fun steps(): Sequence<Direction> = sequence {
            repeat(stepsNum) {
                yield(direction)
            }
        }
    }

    private fun parseCommand(str: String): Command = str.split(" ").let { parts ->
        Command(Direction.valueOf(parts[0]), parts[1].toInt())
    }
}