import kotlin.math.abs
import kotlin.math.sign

class Day009 {

    companion object {
        private val visitedTails = mutableSetOf<Point>()
    }

    var initialPoint = State(Point(0, 0), Point(0, 0))
    fun moveTheSnake(input: List<String>): Int {
        println(input.size)
        input.forEach {
            makeMove(initialPoint, it[2].digitToInt(), it[0].toPoint())
        }
        println(visitedTails)
        return visitedTails.size
    }

    data class State(
        val head: Point,
        val tail: Point
    )

    data class Point(
        val x: Int,
        val y: Int
    ) {
        infix operator fun plus(that: Point) =
            Point(this.x + that.x, this.y + that.y)

        fun moveTowards(other: Point): Point =
            Point(
                (other.x - x).sign + x,
                (other.y - y).sign + y
            )
    }

    private fun makeMove(initialState: State, numberOfTimes: Int, direction: Point): State {
        var head = initialState.head
        var tail = initialState.tail
        repeat(numberOfTimes) {
//            println("Step " + (it + 1) + " head $head and tail $tail")
            head += direction
            tail = moveTailAbs(tail, head)
            initialPoint = State(head, tail)
//            println("after move $initialPoint")
        }
        return State(head, tail)
    }

    private fun moveTailAbs(tailInitial: Point, headAfter: Point): Point {
        val result =
            if (abs(headAfter.x - abs(tailInitial.x)) <= 1 && abs(headAfter.y - abs(tailInitial.y)) <= 1) {
//        if ((headAfter.x - tailInitial.x).absoluteValue <= 1 && (headAfter.y - tailInitial.y).absoluteValue <= 1) {
                tailInitial
            } else {
            /*Point(
                    (headAfter.x - tailInitial.x).sign + tailInitial.x,
                    (headAfter.y - tailInitial.y).sign + tailInitial.y
                )*/
                tailInitial.moveTowards(headAfter)
            }

        visitedTails.add(result)
        return result
    }



    private fun Char.toPoint(): Point {
        return when (this) {
            'R' -> Point(1, 0)
            'L' -> Point(-1, 0)
            'U' -> Point(0, 1)
            'D' -> Point(0, -1)
            else -> {
                error("Value not valid")
            }
        }
    }
}

