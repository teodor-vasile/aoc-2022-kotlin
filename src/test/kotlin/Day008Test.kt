import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class Day008Test {

    private val day008 = Day008()

    @Test
    fun day08part1() {
        Assertions.assertEquals(1715, day008.visibleTreesCount(readInputLines("Day08_input")))
    }

    @Test
    fun day08part2() {
        Assertions.assertEquals(374400, day008.bestVisibility(readInputLines("Day08_input")))
    }
}