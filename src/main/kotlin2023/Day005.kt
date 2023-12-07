package main.kotlin2023

class Day005 {

    fun part1(lines: String): Long {
        val parsedInput = parseInput(lines)
        val seeds = parsedInput.get(0).get(0)
        val seedMaps = parsedInput.drop(1)
        val locationValues = mutableSetOf<Long>()
        for (seed in seeds) {
            val foundCorrespondent = findCorrespondent(seed, seedMaps[0])
            val foundCorrespondent2 = findCorrespondent(foundCorrespondent, seedMaps[1])
            val foundCorrespondent3 = findCorrespondent(foundCorrespondent2, seedMaps[2])
            val foundCorrespondent4 = findCorrespondent(foundCorrespondent3, seedMaps[3])
            val foundCorrespondent5 = findCorrespondent(foundCorrespondent4, seedMaps[4])
            val foundCorrespondent6 = findCorrespondent(foundCorrespondent5, seedMaps[5])
            val foundCorrespondentFinal = findCorrespondent(foundCorrespondent6, seedMaps[6])
            locationValues.add(foundCorrespondentFinal)
        }
        return locationValues.min()
    }
    fun part2(lines: String): Long {
        val parsedInput = parseInput(lines)
        val seedsRaw = parsedInput.get(0).get(0)
//        val seeds = mutableSetOf<Long>()
//        for (i in 0..seedsRaw.size - 2 step 2) {
//            seeds.addAll(seedsRaw[i]..seedsRaw[i] + seedsRaw[i + 1])
//        }
        val seeds = sequence {
            for (i in 0..seedsRaw.size-2 step 2) {
                yieldAll(seedsRaw[i] .. seedsRaw[i]+seedsRaw[i+1])
            }
        }
        val seedMaps = parsedInput.drop(1)
        val locationValues = mutableSetOf<Long>()
        for (seed in seeds) {
            val foundCorrespondent = findCorrespondent(seed, seedMaps[0])
            val foundCorrespondent2 = findCorrespondent(foundCorrespondent, seedMaps[1])
            val foundCorrespondent3 = findCorrespondent(foundCorrespondent2, seedMaps[2])
            val foundCorrespondent4 = findCorrespondent(foundCorrespondent3, seedMaps[3])
            val foundCorrespondent5 = findCorrespondent(foundCorrespondent4, seedMaps[4])
            val foundCorrespondent6 = findCorrespondent(foundCorrespondent5, seedMaps[5])
            val foundCorrespondentFinal = findCorrespondent(foundCorrespondent6, seedMaps[6])
            locationValues.add(foundCorrespondentFinal)
        }
        return locationValues.min()
    }

    private fun findCorrespondent(source: Long, targets: List<List<Long>>): Long {
        for (target in targets) {
            if (source >= target[1] && source <= target[1] + target[2]) {
                return target[0] + source - target[1]
            }
        }
        return source
    }

    private fun parseInput(input: String) = input.split("\n\n")
        .map { eachLine ->
            eachLine.split("\n")
                .map { it.dropWhile { !it.isDigit() } }
                .map {
                    it.split(' ')
                        .filter { it.isNotEmpty() && it.all(Character::isDigit) }
                        .map(String::toLong)
                }
                .filter { it.isNotEmpty() }
        }
}
