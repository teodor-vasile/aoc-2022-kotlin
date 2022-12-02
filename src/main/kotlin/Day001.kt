class Day001 {
    fun part1(input: String): Int {
        val data = parseInput(input)
        return data.maxOf { it.sum() }
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
}