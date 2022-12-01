package day1

object Day1 {

    fun solvePart1(): Int {
        var max = 0
        var currentSum = 0

        readInputLines().forEach {
            if (it.isEmpty()) {
                max = currentSum.coerceAtLeast(max)
                currentSum = 0
            }
            else {
                currentSum += it.toInt()
            }
        }

        return max
    }

    fun solvePart2(): Int {
        val sums = mutableListOf<Int>(0)

        readInputLines().forEach {
            if (it.isEmpty()) {
                sums.add(0)
            }
            else {
                sums[sums.size - 1] += it.toInt()
            }
        }

        sums.sort()

        return sums.takeLast(3).sum()
    }

    private fun readInputLines() = Day1::class.java.getResource("/day1/input")!!.readText().lines()
}