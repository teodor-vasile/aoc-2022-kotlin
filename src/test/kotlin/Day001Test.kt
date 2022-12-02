import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day001Test {

    @Test
    fun day01Part1() {
    val testInput = readInput("Day01Part1")
        val day001 = Day001()
        assertEquals(24000, day001.part1(testInput))
    }

}