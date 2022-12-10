package day7

import readLines
import java.util.LinkedList
import kotlin.streams.asSequence


object Day7 {

    private interface ConsoleRecord

    private enum class ChangeDirectory: ConsoleRecord {
        IN, OUT
    }

    private data class Filesize(val size: Long): ConsoleRecord

    fun solvePart1() = folderSizes()
        .filter { it <= 100_000 }
        .sum()

    fun solvePart2(): Long {
        val totalDiskSize = 70_000_000
        val updateRequires = 30_000_000
        val spaceToFree = updateRequires + getTotalDiskUsed() - totalDiskSize

        return folderSizes()
            .filter { it >= spaceToFree }
            .min()
    }

    private fun getTotalDiskUsed() = folderSizes().max()

    private fun folderSizes() = readLines("/day7/input")
        .filter { isMeaningfulRecord(it) }
        .map { toRecord(it) }
        .asSequence()
        .calculateFoldersSizes()

    private fun isMeaningfulRecord(line: String) =
        line != "$ ls" && !line.startsWith("dir ") && line != "$ cd /"

    private fun toRecord(line: String): ConsoleRecord = when {
        line == "$ cd .." -> ChangeDirectory.OUT
        line.startsWith("$ cd") -> ChangeDirectory.IN
        else -> Filesize(line.split(" ")[0].toLong())
    }

    private fun calculatingFoldersSizes(consoleRecords: Sequence<ConsoleRecord>): Sequence<Long> = sequence {
        val currentPathSizes = LinkedList<Long>()
        currentPathSizes.add(0)

        val removeLastDir = fun (): Long {
            val currentDirSize = currentPathSizes.removeLast()

            if (currentPathSizes.isNotEmpty()) {
                currentPathSizes[currentPathSizes.lastIndex] += currentDirSize
            }

            return currentDirSize
        }

        consoleRecords.forEach {
            when (it) {
                ChangeDirectory.OUT -> yield(removeLastDir())
                ChangeDirectory.IN -> currentPathSizes.add(0)
                is Filesize -> currentPathSizes[currentPathSizes.lastIndex] += it.size
            }
        }

        while (currentPathSizes.isNotEmpty()) {
            yield(removeLastDir())
        }
    }

    private fun Sequence<ConsoleRecord>.calculateFoldersSizes() = calculatingFoldersSizes(this)
}

