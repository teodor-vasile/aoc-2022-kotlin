import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day003Test {

    @Test
    fun day02part1() {
    val testInput = readInputLines("Day03part1")
        val day003 = Day003()
        assertEquals(7878, day003.part1(testInput))
    }

//    @Test
//    fun day02part2() {
//    val testInput = readInputLines("Day02part1")
//        val day002 = Day002()
//        assertEquals(14060, day002.part2(testInput))
//    }


}