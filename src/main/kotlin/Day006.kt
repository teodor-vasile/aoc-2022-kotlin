class Day006 {

    fun findNonRepeatingSequenceIndexFunctional(input: String, numberOfDistinctChars: Int): Int {
        return (0 until input.length - numberOfDistinctChars - 1)
            .map { input.substring(it, it + numberOfDistinctChars) }
            .firstOrNull { it.toSet().size == numberOfDistinctChars }
            ?.let { input.indexOf(it) + numberOfDistinctChars } ?: -1
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

}

