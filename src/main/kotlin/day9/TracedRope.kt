package day9

data class TracedRope(val rope: RopeSegment, val trace: Set<Point>) {

    fun move(movement: Movement): TracedRope = rope.move(movement).let {
        TracedRope(it, trace + it.end())
    }
}

fun createTracedRope(length: Int) = TracedRope(createRope(Point(0, 0), length), emptySet())
