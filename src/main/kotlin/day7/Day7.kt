package day7

import readLines
import java.util.LinkedList

object Day7 {

    fun solvePart1(): Long {
        var totalSizeOfSmallDirs = 0L

        analyzeConsoleLog {
            if (it <= 100000) {
                totalSizeOfSmallDirs += it
            }
        }

        return totalSizeOfSmallDirs
    }

    fun solvePart2(): Long {
        val totalDiskSize = 70000000
        val updateRequires = 30000000
        val spaceToFree = updateRequires + getTotalDiskUsed() - totalDiskSize

        var smallestSuitableDirSize = Long.MAX_VALUE

        analyzeConsoleLog {
            if (it in spaceToFree..smallestSuitableDirSize) {
                smallestSuitableDirSize = it
            }
        }

        return smallestSuitableDirSize
    }

    private fun getTotalDiskUsed(): Long {
        var largest = 0L

        analyzeConsoleLog {
            if (it > largest) {
                largest = it
            }
        }

        return largest
    }

    private fun analyzeConsoleLog(consumeDirectorySize: (Long) -> Unit) {
        val analyser = DiskUsageAnalyser(consumeDirectorySize)

        readLines("/day7/input").forEach {
            when {
                it.startsWith("$ cd") -> {
                    when (it.substring(5)) {
                        "/" -> analyser.goToRoot()
                        ".." -> analyser.goOut()
                        else -> analyser.goIn()
                    }
                }
                it != "$ ls" && !it.startsWith("dir ") -> {
                    analyser.noticeFile(it.split(" ")[0].toLong())
                }
            }
        }

        analyser.goToRoot()
    }

    class DiskUsageAnalyser(private val consumeDirectorySize: (Long) -> Unit) {

        private val currentPathSizes = LinkedList<Long>()

        fun goToRoot() {
            while (currentPathSizes.isNotEmpty()) {
                goOut()
            }

            goIn()
        }

        fun goOut() {
            val currentDirSize = currentPathSizes.removeLast()
            if (currentPathSizes.isNotEmpty()) {
                currentPathSizes[currentPathSizes.lastIndex] += currentDirSize
            }

            consumeDirectorySize(currentDirSize)
        }

        fun goIn() {
            currentPathSizes.add(0)
        }

        fun noticeFile(size: Long) {
            currentPathSizes[currentPathSizes.lastIndex] += size
        }
    }
}