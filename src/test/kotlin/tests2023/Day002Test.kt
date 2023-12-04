package tests2023

import main.kotlin2023.Day002
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import readInputLines

internal class Day002Test {

    private val day002 = Day002()

    @Test
    fun day02part1() {
        val testInput = readInputLines("Day02_2023_Part1")
        assertEquals(2486, day002.part1(testInput))
    }

    @Test
    fun day02part2() {
        val testInput = readInputLines("Day02_2023_Part1")
        assertEquals(87984, day002.part2(testInput))
    }
}
