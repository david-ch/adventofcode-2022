package day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun should_solve_part_1() {
        assertEquals(Day2.solvePart1(), 13809)
    }

    @Test
    fun should_solve_part_2() {
        assertEquals(Day2.solvePart2(), 12316)
    }
}