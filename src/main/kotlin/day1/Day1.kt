package day1

object Day1 {

    fun solvePart1(): Int {
        var max = 0
        var currentSum = 0

        readInput().forEach {
            if (it == "") {
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
        var currentElfIdx = 0

        readInput().forEach {
            if (it == "") {
                currentElfIdx++
                sums.add(0)
            }
            else {
                sums[currentElfIdx] += it.toInt()
            }
        }

        sums.sort()

        return sums.takeLast(3).sum()
    }

    private fun readInput() = Day1::class.java.getResource("/day1/input")!!.readText().lines()
}