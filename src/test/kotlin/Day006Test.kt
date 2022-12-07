import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class Day006Test {

    private val day006 = Day006()

    @Test
    fun day05part1() {
        val testInput = readInputText("Day06Part1")
        assertEquals(1578, day006.findNonRepeatingSequenceIndexFunctional(testInput))
    }

}