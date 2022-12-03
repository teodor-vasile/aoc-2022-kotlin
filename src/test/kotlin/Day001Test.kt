import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day001Test {

    private val day001 = Day001()

    @Test
    fun day01Part1() {
    val testInput = readInputText("Day01Part1")
        assertEquals(66306, day001.part1(testInput))
    }

    @Test
    fun day01Part2() {
    val testInput = readInputText("Day01Part1")
        assertEquals(195292, day001.part2(testInput))
    }

}