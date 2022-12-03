import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day003Test {

    private val day003 = Day003()

    @Test
    fun day02part1() {
    val testInput = readInputLines("Day03part1")
        assertEquals(7878, day003.part1(testInput))
    }

    @Test
    fun day02part2() {
    val testInput = readInputLines("Day03part1")
        assertEquals(2760, day003.part2(testInput))
    }
}