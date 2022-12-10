import kotlin.math.abs

class Day009 {

    var initialPoint = State(Point(0, 0), Point(0, 0))
    var headLastPoint = State(Point(0, 0), Point(0, 0))
    fun moveTheSnake(input: List<String>): Int {
        input.forEach {
            print(it[2].digitToInt())
            println(it[0])
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
    }

    private fun makeMove(initialState: State, numberOfTimes: Int, direction: Point): State {
        var head = initialState.head
        var tail = initialState.tail
        repeat(numberOfTimes) {
            println("Step " + (it + 1) + " head $head and tail $tail")
//            tail = moveTailTryout(head, tail, it == 0)
//            tail = moveTailTryout2(head, tail, head+direction, it ==0)
            tail = moveTailAbs(head, tail, head+direction)
            head += direction
            initialPoint = State(head, tail)
            println("after move $initialPoint")
        }
        return State(head, tail)
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

    private fun moveTail(
        headInitial: Point,
        tailInitial: Point,
        directionChange: Boolean = false,
        numberOfMoves: Int
    ): Point {

        val result = if (headInitial == tailInitial || directionChange) {
            tailInitial
        } else {
            headInitial
        }
        visitedTails.add(result)

        return result
    }

    private fun moveTailTryout(headInitial: Point, tailInitial: Point, directionChange: Boolean = false): Point {

        val tailExpected = if (headInitial == tailInitial) {
            tailInitial
        } else if (directionChange && (headInitial.x - tailInitial.x <= 1) && (headInitial.y - tailInitial.y <= 1)) {
            tailInitial
        } else if (directionChange && ((headInitial.x - tailInitial.x > 1) || (headInitial.y - tailInitial.y > 1))) {
            initialPoint.head
        } else {
        headInitial
    }
    visitedTails.add(tailExpected)

    return tailExpected
}

    private fun moveTailTryout2(headInitial: Point, tailInitial: Point, headAfter: Point, directionChange: Boolean): Point {
        val result = if (headInitial == tailInitial || directionChange) {
            tailInitial
        } else if (abs(headAfter.x - tailInitial.x) <= 1 && abs(headAfter.y - tailInitial.y) <= 1) {
            tailInitial
        } else if (headAfter.x == tailInitial.x && abs(headAfter.y - tailInitial.y) <= 1) {
            headInitial
        } else if (headAfter.y == tailInitial.y && abs(headAfter.x - tailInitial.x) <= 1) {
            headInitial
        } else if (abs(headAfter.x - tailInitial.x) > 1) {
            headInitial
        } else if (abs(headAfter.y - tailInitial.y) > 1) {
            headInitial
        }

//        headInitial = Point(x=2, y=3)
//        tailInitial =  Point(x=2, y=4)
//            headAfter = Point(x=3, y=3)
//            tailAfter = Point(x=2, y=3)
//        Step 2 head Point(x=2, y=3) and tail Point(x=2, y=4)
//        after move State(head=Point(x=3, y=3), tail=Point(x=2, y=3))

        else {
            headInitial
        }
        visitedTails.add(result)

        return result
}

    private fun moveTailAbs(headInitial: Point, tailInitial: Point, headAfter: Point) : Point{
        val result =
        if (abs(headAfter.x - tailInitial.x) <= 1 && abs(headAfter.y - tailInitial.y) <= 1) {
            tailInitial
        } else {
            headInitial
        }
        visitedTails.add(result)
        return result
    }

companion object {
    private val visitedTails = mutableSetOf<Point>()
}

}

