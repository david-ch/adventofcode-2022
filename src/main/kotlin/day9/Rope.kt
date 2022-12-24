package day9


import kotlin.math.absoluteValue

data class RopeSegment(val head: Point, val tail: RopeSegment?) {

    fun move(movement: Movement): RopeSegment = head.move(movement).let {
        RopeSegment(it, keepUpTail(it))
    }

    fun end(): Point = tail?.end() ?: head

    private fun keepUpTail(newHead: Point): RopeSegment? {
        if (tail == null) return null

        val dx = newHead.x - tail.head.x
        val dy = newHead.y - tail.head.y

        if (dx.absoluteValue > 1 || dy.absoluteValue > 1) {
            return tail.move(Movement(
                dx = dx.coerceIn(-1..1),
                dy = dy.coerceIn(-1..1)
            ))
        }

        return tail
    }
}

fun createRope(point: Point, length: Int): RopeSegment = RopeSegment(
    point,
    if (length == 1) null else createRope(point, length - 1)
)

data class Point(val x: Int, val y: Int) {

    fun move(movement: Movement): Point = Point(x + movement.dx, y + movement.dy)
}

data class Movement(val dx: Int, val dy: Int) {
    init {
        require(dx in -1..1)
        require(dy in -1..1)
    }
}