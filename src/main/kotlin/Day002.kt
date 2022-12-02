class Day002 {
    fun part1(input: String): Int {
        val checkMap: Map<String, Int> = mapOf(Pair("B X", 1), Pair("C Y", 2), Pair("A Z", 3),
            Pair("A X", 4), Pair("B Y", 5), Pair("C Z", 6), Pair("C X", 7), Pair("A Y", 8), Pair("B Z", 9))

        return parseInput(input).sumOf { checkMap.getValue(it) }
    }

    fun part2(input: String): Int {
        val checkMap: Map<String, Int> = mapOf(Pair("B X", 1), Pair("C Y", 6), Pair("A Z", 8),
            Pair("A X", 3), Pair("B Y", 5), Pair("C Z", 7), Pair("C X", 2), Pair("A Y", 4), Pair("B Z", 9))
        return parseInput(input).sumOf { checkMap.getValue(it) }
    }

    private fun parseInput(input: String) = input
        .split("\n")

}