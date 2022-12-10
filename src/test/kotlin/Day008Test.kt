import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class Day008Test {

    private val day008 = Day008()


    @Test
    fun day09part1() {
        Assertions.assertEquals(21, day008.visibleTreesCount(readInputLines("Day08_test")))
    }
}