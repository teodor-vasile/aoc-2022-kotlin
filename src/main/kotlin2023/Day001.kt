package main.kotlin2023

class Day001 {
    fun part1(input: String): Int {
        val data = parseInput2023(input)
        return data.map { row -> row.find { it.isDigit() }.toString() + row.findLast { it.isDigit() }.toString() }
            .sumOf { it.toInt() }
    }

    fun part2(input: String): Int {
        val data = parseInput(input)
        return data
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()
    }

    private fun parseInput(input: String) = input.split("\n\n")
        .map { elf -> elf.lines().map { it.toInt() } }

    private fun parseInput2023(input: String) = input.split("\n")
}
