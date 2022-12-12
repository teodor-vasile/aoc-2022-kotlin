class Day11 {

    fun solvePart1(input: String): Int {

        val map = input.split("\n\n")
            .map { monkey -> monkey.lines()[1].split(":")[1].trim().split(",").forEach { it.trim().toInt() } }


        println(map.forEach { println(it) })
        // parse the input
        val monkeys = input.split("\n\n")
            .forEach { monkey ->
                println( Monkey(
                    items = getListOfItems(monkey),
                    operator = getOperator(monkey),
                    worryMultiplier = getWorryMultiplier(monkey),
                    divisibleBy = getDivisibleBy(monkey),
                    actionIsTrue = getActionIsTrue(monkey),
                    actionIsFalse = getActionIsFalse(monkey)
                ))
            }

        return 3
    }

    data class Monkey(
        var items: List<Int>,
        val operator: String,
        val worryMultiplier: String,
        val divisibleBy: Int,
        val actionIsTrue: Int,
        val actionIsFalse: Int
    )

    private fun parseInput(input: String) = input.split("\n\n").map { monkey -> monkey.lines().map { it.toInt() } }

    private fun getListOfItems(monkey: String): List<Int> {
        val worryMultiplier =
            monkey.lines()
                .find { it.trim().startsWith("Starting") }
                .let {
                    it!!.substring(18, it.length)
                        .split(",")
                        .map { it.trim().toInt() }
                }

        return worryMultiplier
    }

    private fun getWorryMultiplier(monkey: String): String {
        val worryMultiplier = monkey.lines()
            .find { it.trim().startsWith("Operation") }
            .let {
                it!!.substring(25, it.length)
            }
        return worryMultiplier
    }

    private fun getOperator(monkey: String): String {
        val worryMultiplier =
            monkey.lines()
                .find { it.trim().startsWith("Operation") }
                .let {
                    it!!.substring(23, 24)
                }
        return worryMultiplier
    }

    private fun getDivisibleBy(lines: String): Int {
        val regex = """Test: divisible by (\d+)""".toRegex()
        val divisibleBy = regex.find(lines)
        val (value) = divisibleBy!!.destructured

        return value.toInt()
    }

    private fun getActionIsTrue(lines: String): Int {
        val regex = """If true: throw to monkey (\d+)""".toRegex()
            val divisibleBy = regex.find(lines)
            val (value) = divisibleBy!!.destructured
        return value.toInt()
    }

    private fun getActionIsFalse(lines: String): Int {
        val regex = """If false: throw to monkey (\d+)""".toRegex()
            val divisibleBy = regex.find(lines)
            val (value) = divisibleBy!!.destructured
        return value.toInt()
    }
}