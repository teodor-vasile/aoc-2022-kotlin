package tests2023

import junit.framework.TestCase.assertEquals
import main.kotlin2023.Day001
import org.junit.Test
import readInputText

internal class Day001Test {

    private val day001 = Day001()

    @Test
    fun day01Part1() {
        val testInput = readInputText("Day01_2023_Part1")
        assertEquals(56042, day001.part1(testInput))
    }

    @Test
    fun day01Part2() {
        val testInput = readInputText("Day01Part1")
        assertEquals(195292, day001.part2(testInput))
    }
}
