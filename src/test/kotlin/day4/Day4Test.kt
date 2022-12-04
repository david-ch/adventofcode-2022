package day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    fun should_solve_part_1() {
        assertEquals(Day4.solvePart1(), 431)
    }

    @Test
    fun should_solve_part_2() {
        assertEquals(Day4.solvePart2(), 823)
    }
}