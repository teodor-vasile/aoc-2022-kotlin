import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day004Test {

    private val day004 = Day004()

    @Test
    fun day04part1() {
        val testInput = readInputLinesSplitBy("Day04part1", ',')
        assertEquals(500, day004.part1(testInput))
    }

    @Test
    fun day04part2() {
        val testInput = readInputLinesSplitBy("Day04part1", ',')
        assertEquals(815, day004.part2(testInput))
    }

}