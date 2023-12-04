package tests2023

import main.kotlin2023.Day004
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import readInputLines

internal class Day004Test {

    private val day004 = Day004()

    @Test
    fun day05part1() {
        val testInput = readInputLines("Day04_2023_Part1")
        assertEquals(23847, day004.part1(testInput))
    }

    @Test
    fun day05part2() {
        val testInput = readInputLines("Day04_2023_Part1")
        assertEquals(8570000, day004.part2(testInput))
    }
}
