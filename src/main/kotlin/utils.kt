import day1.Day1

fun readLines(filename: String) = Day1::class.java.getResourceAsStream(filename)!!
    .bufferedReader()
    .lines()