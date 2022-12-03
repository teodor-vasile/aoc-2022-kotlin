import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day002Test {

    private val day002 = Day002()

    @Test
    fun day02part1() {
        val testInput = readInputLines("Day02part1")
        assertEquals(10624, day002.part1(testInput))
    }

    @Test
    fun day02part2() {
        val testInput = readInputLines("Day02part1")
        assertEquals(14060, day002.part2(testInput))
    }

}