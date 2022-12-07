class Day006 {


    fun part1(lines: String): Int {

        return 5
    }

    fun findNonRepeatingSequenceIndex(input: String): Int {
        var result = -1
        for (i in 0 until input.length - 3) {
            val sequence = input.substring(i, i + 4)
            if (sequence.toSet().size == 4) {
                result = i + 4
                break
            }
        }
        return result
    }

    fun findNonRepeatingSequenceIndexFunctional(input: String): Int {
        return (0 until input.length - 3)
            .map { input.substring(it, it + 4) }
            .firstOrNull { it.toSet().size == 4 }
            ?.let { input.indexOf(it) + 4 } ?: -1
    }

}

