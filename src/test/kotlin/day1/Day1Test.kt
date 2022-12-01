package day1

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Day1Test {

    @Test
    fun should_solve_part_1() {
        assertEquals(Day1.solvePart1(), 71471)
    }

    @Test
    fun should_solve_part_2() {
        assertEquals(Day1.solvePart2(), 211189)
    }
}