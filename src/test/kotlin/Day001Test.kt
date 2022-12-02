import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day001Test {

    @Test
    fun day01Part1() {
    val testInput = readInput("Day01_test")
        val day001 = Day001()
        assertEquals(2400, day001.part1(testInput))

    }

}