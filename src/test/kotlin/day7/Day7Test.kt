package day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day7Test {

    @Test
    fun should_solve_part_1() {
        assertEquals(Day7.solvePart1(), 1513699)
    }

    @Test
    fun should_solve_part_2() {
        assertEquals(Day7.solvePart2(), 7991939)
    }
}