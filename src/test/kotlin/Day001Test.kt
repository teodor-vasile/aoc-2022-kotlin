import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day001Test {

    @Test
    fun day01Part1() {
    val testInput = readInput("Day01Part1")
        val day001 = Day001()
        assertEquals(66306, day001.part1(testInput))
    }

    @Test
    fun day01Part2() {
    val testInput = readInput("Day01Part1")
        val day001 = Day001()
        assertEquals(45000, day001.part2(testInput))
    }

}