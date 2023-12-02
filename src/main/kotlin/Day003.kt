class Day003 {
    fun part1(input: List<String>): Int {
        var prioritiesSum = 0
        for (rucksack in input) {
            val firstHalf = rucksack.subSequence(0, rucksack.length / 2)
            val lastHalf = rucksack.subSequence(rucksack.length / 2, rucksack.length)
            for (char in lastHalf) {
                if (firstHalf.contains(char)) {
                    val itemPriority = if (char.isLowerCase()) char.code - 96 else char.code - 38
                    prioritiesSum += itemPriority
                    break
                }
            }
        }
        return prioritiesSum
    }

    fun part2(input: List<String>): Int {
        val chunkedInput = input.chunked(3)
        var prioritiesSum = 0
        for (chunk in chunkedInput) {
            for (char in chunk[0]) {
                if (chunk[1].contains(char) && chunk[2].contains(char)) {
                    val itemPriority = if (char.isLowerCase()) char.code - 96 else char.code - 38
                    prioritiesSum += itemPriority
                    break
                }
            }
        }
        return prioritiesSum

        // check out zipWithNext() for this solution
        // and intersect() method
        // single() to return one value
    }
}
