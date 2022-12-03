import day1.Day1
import java.util.stream.Stream

fun readLines(filename: String): Stream<String> = Day1::class.java.getResourceAsStream(filename)!!
    .bufferedReader()
    .lines()