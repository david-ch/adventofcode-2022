package day10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day10Test {

    @Test
    fun should_solve_part_1() {
        assertEquals(Day10.solvePart1(), 15680)
    }

    @Test
    fun should_solve_part_2() {
        val expectedResult = """
            ####.####.###..####.#..#..##..#..#.###..
            ...#.#....#..#.#....#..#.#..#.#..#.#..#.
            ..#..###..###..###..####.#....#..#.#..#.
            .#...#....#..#.#....#..#.#.##.#..#.###..
            #....#....#..#.#....#..#.#..#.#..#.#....
            ####.#....###..#....#..#..###..##..#....
        """.trimIndent()

        assertEquals(Day10.solvePart2(), expectedResult)
    }
}