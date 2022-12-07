import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class Day006Test {

    private val day006 = Day006()

        val testInput = readInputText("Day06Part1")
    @Test
    fun day05part1() {
        assertEquals(1578, day006.findNonRepeatingSequenceIndexFunctional(testInput, 4))
    }
    @Test
    fun day05part2() {
        assertEquals(2178, day006.findNonRepeatingSequenceIndexFunctional(testInput, 14))
    }

    @Test
    fun testEmptyInput() {
        val testInput = ""
        val expected = -1
        val result = day006.findNonRepeatingSequenceIndexFunctional(testInput, 4)
        assertEquals(expected, result)
    }

    @Test
    fun testShortInput() {
        val testInput = "abc"
        val expected = -1
        val result = day006.findNonRepeatingSequenceIndexFunctional(testInput, 4)
        assertEquals(expected, result)
    }

    @Test
    fun testInputWithNonRepeatingSequence() {
        val testInput = "abcdefghijklmnopqrstuvwxyz"
        val expected = 4
        val result = day006.findNonRepeatingSequenceIndexFunctional(testInput, 4)
        assertEquals(expected, result)
    }

    @Test
    fun testInputWithoutNonRepeatingSequence() {
        val testInput = "aaaaaaabbbbbbbbccccccccdddddddd"
        val expected = -1
        val result = day006.findNonRepeatingSequenceIndexFunctional(testInput, 4)
        assertEquals(expected, result)
    }

}