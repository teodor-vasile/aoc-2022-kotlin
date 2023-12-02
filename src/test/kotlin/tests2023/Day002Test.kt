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
        assertEquals(100, day002.part1(testInput))
    }

//    @Test
//    fun day05part2() {
//        val testInput = readInputLines("Day05part1")
//        assertEquals("QNDWLMGNS", day002.part2(testInput))
//    }
}
