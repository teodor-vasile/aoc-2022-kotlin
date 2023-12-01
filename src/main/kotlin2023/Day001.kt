package main.kotlin2023

class Day001 {
    fun part1(input: String): Int {
        val data = parseInput(input)
        return data.map { row -> row.find { it.isDigit() }.toString() + row.findLast { it.isDigit() }.toString() }
            .sumOf { it.toInt() }
    }

    fun part2(input: String): Int {
        val data = parseInput(input)
        val mapped = data
            .map { row -> row.replace("nine", "n9e", false) }
            .map { row -> row.replace("eight", "e8t", false) }
            .map { row -> row.replace("seven", "s7n", false) }
            .map { row -> row.replace("six", "s6x", false) }
            .map { row -> row.replace("five", "f5e", false) }
            .map { row -> row.replace("four", "f4r", false) }
            .map { row -> row.replace("three", "t3e", false) }
            .map { row -> row.replace("two", "t2o", false) }
            .map { row -> row.replace("one", "o1e", false) }
            .map { row -> row.find { it.isDigit() }.toString() + row.findLast { it.isDigit() }.toString() }
            .sumOf { it.toInt() }

        return mapped
    }
    private fun parseInput(input: String) = input.split("\n")
}
