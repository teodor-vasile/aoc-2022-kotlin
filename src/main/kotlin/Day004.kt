class Day004 {
    fun part1(input: List<List<String>>): Int {
        var counter = 0
        for (elfPair in input) {
            val firstElf = elfPair[0].split('-').map { it.toInt() }
            val secondElf = elfPair[1].split('-').map { it.toInt() }
            if ((firstElf[0] >= secondElf[0] && firstElf[1] <= secondElf[1]) ||
                (secondElf[0] >= firstElf[0] && secondElf[1] <= firstElf[1]))
                counter++
        }
        return counter
    }

    fun part2(input: List<List<String>>): Int {
        var counter = 0
        for (elfPair in input) {
            val firstElf = elfPair[0].split('-').map { it.toInt() }
            val secondElf = elfPair[1].split('-').map { it.toInt() }
            if ((firstElf[1] >= secondElf[0] && firstElf[1] <= secondElf[1]) ||
                (secondElf[1] >= firstElf[0] && secondElf[1] <= firstElf[1]))
                counter++
        }
        return counter
    }
}
