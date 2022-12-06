import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day005Test {

    private val day005 = Day005()

    @Test
    fun day05part1() {
        val testInput = readInputLines("Day05part1")
        assertEquals("CNSZFDVLJ", day005.part1(testInput))
    }


}