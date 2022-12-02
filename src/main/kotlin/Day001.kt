class Day001 {
    fun part1(input: String): Int {
        val data = input.split("\n\n")
            .map { elf -> elf.lines().map { it.toInt() } }
        return data.maxOf { it.sum() }
    }
}