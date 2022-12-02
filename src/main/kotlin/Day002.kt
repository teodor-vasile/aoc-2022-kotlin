class Day002 {
    fun part1(input: String): Int {
        val checkMap: MutableMap<String, Int> = mutableMapOf()
        checkMap["B X"] = 1
        checkMap["B X"] = 1
        checkMap["C Y"] = 2
        checkMap["A Z"] = 3
        checkMap["A X"] = 4
        checkMap["B Y"] = 5
        checkMap["C Z"] = 6
        checkMap["C X"] = 7
        checkMap["A Y"] = 8
        checkMap["B Z"] = 9
        return parseInput(input).sumOf { checkMap.getValue(it) }
    }

    private fun parseInput(input: String) = input
        .split("\n")

}