import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class Day11Test {

    private val day011 = Day11()
    private val test = "test"
    private val real = "input"

    @Test
    fun day11part1() {
        Assertions.assertEquals(151312, day011.solvePart1(readInputText("Day011_$real")))
    }
}