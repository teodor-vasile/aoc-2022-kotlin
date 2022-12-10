import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class Day009Test {

    private val day009 = Day009()
    private val day009NotMine = Day09N(readInputLines("Day09Part1"))

    companion object {
        private val visitedTails = mutableSetOf<Point>()
    }

    @Test
    fun day09part1() {
        assertEquals(13, day009.moveTheSnake(readInputLines("Day09Part1")))
    }

    @Test
    fun day09part1NotMine() {
        assertEquals(13, day009NotMine.solvePart2())
    }

    @Test
    fun firstMove() {
        //given
        val initialHead: Point = Point(0, 0)
        val initialTail: Point = Point(0, 0)
        val expectedHead: Point = Point(1, 0)
        val expectedTail: Point = Point(0, 0)

        assertEquals(initialHead + R, expectedHead)
        assertEquals(moveTail(initialHead, initialTail), expectedTail)
    }

    @Test
    fun secondMove() {
        //given
        val initialHead: Point = Point(1, 0)
        val initialTail: Point = Point(0, 0)
        val expectedHead: Point = Point(2, 0)
        val expectedTail: Point = Point(1, 0)

        assertEquals(initialHead + R, expectedHead)
        assertEquals(moveTail(initialHead, initialTail), expectedTail)

    }

    @Test
    fun thirdMoveVertical() {
        //given
        val initialHead: Point = Point(2, 0)
        val initialTail: Point = Point(1, 0)
        val expectedHead: Point = Point(2, 1)
        val expectedTail: Point = Point(1, 0)

        //new direction
        var directionChange = true

        assertEquals(initialHead + U, expectedHead)
        assertEquals(moveTail(initialHead, initialTail, directionChange), expectedTail)

    }

    @Test
    fun fourthMoveVertical() {
        //given
        val initialHead: Point = Point(2, 1)
        val initialTail: Point = Point(1, 0)
        val expectedHead: Point = Point(2, 2)
        val expectedTail: Point = Point(2, 1)

        var directionChange = false

        assertEquals(initialHead + U, expectedHead)
        assertEquals(moveTail(initialHead, initialTail, directionChange), expectedTail)

    }

    @Test
    fun fifthMoveLeft() {
        //given
        val initialHead: Point = Point(2, 2)
        val initialTail: Point = Point(2, 1)
        val expectedHead: Point = Point(1, 2)
        val expectedTail: Point = Point(2, 1)

        var directionChange = true

        assertEquals(initialHead + L, expectedHead)
        assertEquals(moveTail(initialHead, initialTail, directionChange), expectedTail)

    }

    @Test
    fun move5Times() {
        //given
        val initialHead: Point = Point(2, 2)
        val initialTail: Point = Point(2, 1)
        val expectedHead: Point = Point(1, 2)
        val expectedTail: Point = Point(2, 1)

        var directionChange = true

        assertEquals(initialHead + R, expectedHead)
        assertEquals(initialHead + R, expectedHead)
        assertEquals(initialHead + U, expectedHead)
        assertEquals(initialHead + U, expectedHead)
        assertEquals(initialHead + L, expectedHead)
        assertEquals(moveTail(initialHead, initialTail, directionChange), expectedTail)

    }

    @Test
    fun makeMove() {
        val initialHead: Point = Point(0, 0)
        val initialTail: Point = Point(0, 0)
        val initialState = State(initialHead, initialTail)

        val expectedHead: Point = Point(4, 0)
        val expectedTail: Point = Point(3, 0)
        val expectedState: State = State(expectedHead, expectedTail)

        //when
        val actualState = makeMove(initialState, 4, R)
        assertEquals(actualState, expectedState)
    }

    @Test
    fun makeMoreMoves() {
        val initialHead: Point = Point(0, 0)
        val initialTail: Point = Point(0, 0)
        val initialState = State(initialHead, initialTail)

        val expectedHead: Point = Point(4, 4)
        val expectedTail: Point = Point(4, 3)
        val expectedState: State = State(expectedHead, expectedTail)

        //when
        val step1 = makeMove(initialState, 4, R)
        val actualState = makeMove(step1, 4, U)
        assertEquals(actualState, expectedState)
        assertEquals(visitedTails.size, 7)
    }

    private fun moveTail(headInitial: Point, tailInitial: Point, directionChange: Boolean = false): Point {

        val result = if (headInitial == tailInitial || directionChange) {
            tailInitial
        } else {
            headInitial
        }
        visitedTails.add(result)

        return result
    }

    private fun makeMove(initialState: State, numberOfTimes: Int, direction: Point): State {
        var head = initialState.head
        var tail = initialState.tail
        repeat(numberOfTimes) {
            tail = moveTail(head, tail, it == 0)
            head += direction
        }
        return State(head, tail)
    }

}

val R: Point = Point(1, 0)
val L: Point = Point(-1, 0)
val U: Point = Point(0, 1)
val D: Point = Point(0, -1)

data class Point(
    val x: Int,
    val y: Int
) {
    infix operator fun plus(that: Point) =
        Point(this.x + that.x, this.y + that.y)
}

data class State(
    val head: Point,
    val tail: Point
)

