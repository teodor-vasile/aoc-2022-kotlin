package tests2023

import main.kotlin2023.Day005
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import readInputText

internal class Day005Test {

    private val day005 = Day005()

    @Test
    fun day05part1() {
        val testInput = readInputText("Day05_2023_Part1")
        assertEquals(35, day005.part1(testInput))
    }

//    @Test
//    fun day05part2() {
//        val testInput = readInputLines("Day04_2023_Part1")
//        assertEquals(8570000, day005.part2(testInput))
//    }
}
