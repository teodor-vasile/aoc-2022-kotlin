import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day002Test {

    @Test
    fun day02part1() {
    val testInput = readInput("Day02part1")
        val day002 = Day002()
        assertEquals(10624, day002.part1(testInput))
    }

    @Test
    fun day02part2() {
    val testInput = readInput("Day02part1")
        val day002 = Day002()
        assertEquals(12, day002.part2(testInput))
    }


}