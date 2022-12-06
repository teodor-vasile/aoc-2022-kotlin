class Day004 {

    var counter = 0

    fun part1(elfPairs: List<List<String>>): Int {
        for (elfPair in elfPairs) {
            val firstElf = elfPair[0].split('-').map { it.toInt() }
            val secondElf = elfPair[1].split('-').map { it.toInt() }
            countContainingRanges(firstElf, secondElf)
        }
        return counter
    }

    fun part1Functional(elfPairs: List<List<String>>): Int {
        elfPairs.forEach { elfPair ->
            val firstElf = elfPair[0].split('-').map { it.toInt() }
            val secondElf = elfPair[1].split('-').map { it.toInt() }
            countContainingRanges(firstElf, secondElf) }
        return counter
    }

    private fun countContainingRanges(firstElf: List<Int>, secondElf: List<Int>) {
        if ((firstElf[0] >= secondElf[0] && firstElf[1] <= secondElf[1]) ||
            (secondElf[0] >= firstElf[0] && secondElf[1] <= firstElf[1]))
            counter++
    }

    fun part2(elfPairs: List<List<String>>): Int {
        for (elfPair in elfPairs) {
            val firstElf = elfPair[0].split('-').map { it.toInt() }
            val secondElf = elfPair[1].split('-').map { it.toInt() }
            if ((firstElf[1] >= secondElf[0] && firstElf[1] <= secondElf[1]) ||
                (secondElf[1] >= firstElf[0] && secondElf[1] <= firstElf[1]))
                counter++
        }
        return counter
    }

    fun test() {
    val pair = Pair("primu", "ultimu")
        pair.first
    }

    // transform to Pair<IntRange, IntRange> -> you can use first and last in an IntRange
    // substringBefore() method also useful
    // .count() -> how many of the items in the set match the predicate
    // https://todd.ginsberg.com/post/advent-of-code/2022/day4/

}
