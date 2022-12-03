class Day003 {
    fun part1(input: List<String>): Int {
        var itemPriority: Int
        var prioritiesSum = 0
        for (rucksack in input) {
            val firstHalf = rucksack.subSequence(0, rucksack.length / 2)
            val lastHalf = rucksack.subSequence(rucksack.length / 2, rucksack.length)
            for (char in lastHalf) {
                if (firstHalf.contains(char)) {
                    itemPriority = if (char.isLowerCase()) char.code - 96 else char.code - 38
                    prioritiesSum += itemPriority
                    break
                }
            }
        }
        return prioritiesSum
    }
}