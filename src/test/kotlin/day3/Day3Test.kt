package day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun should_solve_part_1() {
        assertEquals(Day3.solvePart1(), 8053)
    }

    @Test
    fun should_solve_part_2() {
        assertEquals(Day3.solvePart2(), 2425)
    }
}