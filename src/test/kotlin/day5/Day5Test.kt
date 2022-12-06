package day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {

    @Test
    fun should_solve_part_1() {
        assertEquals(Day5.solvePart1(), "BWNCQRMDB")
    }

    @Test
    fun should_solve_part_2() {
        assertEquals(Day5.solvePart2(), "NHWZCBNBF")
    }
}