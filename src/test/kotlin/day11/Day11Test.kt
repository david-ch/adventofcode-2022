package day11

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

class Day11Test {

    @Test
    fun should_solve_part_1() {
        assertEquals(Day11.solvePart1(), BigInteger.valueOf(120384L))
    }

    @Test
    fun should_solve_part_2() {
        assertEquals(Day11.solvePart2(), BigInteger.valueOf(32059801242L))
    }
}