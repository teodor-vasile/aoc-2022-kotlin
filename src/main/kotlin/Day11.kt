
class Day11 {

    fun solvePart1(input: String): Int {

        // parse the input
        val monkeys = input.split("\n\n")
            .map { monkey ->
                Monkey(
                    items = getListOfItems(monkey),
                    operator = getOperator(monkey),
                    worryMultiplier = getWorryMultiplier(monkey),
                    divisibleBy = getDivisibleBy(monkey),
                    actionIsTrue = getActionIsTrue(monkey),
                    actionIsFalse = getActionIsFalse(monkey),
                    operationsPerformed = 0
                )
            }

        repeat(20) {doOperations(monkeys)}


        monkeys.forEach { println(it) }

        return monkeys.sortedByDescending { monkey -> monkey.operationsPerformed }
            .subList(0,2)
            .map { it.operationsPerformed }
            .take(2)
            .fold(1) { acc, value -> acc * value }

    }

    private fun doOperations(monkeys: List<Monkey>) {
        monkeys.forEach {monkey ->
            if (monkey.items.isNotEmpty()) {
                convertWorryMultiplier(monkey)
                calculateWorryLevel(monkey)
                monkeyGetsBored(monkey)
                throwToMonkey(monkey, monkeys)
            }
        }
    }

    data class Monkey(
        var items: ArrayDeque<Int>,
        val operator: String,
        val worryMultiplier: String,
        val divisibleBy: Int,
        val actionIsTrue: Int,
        val actionIsFalse: Int,
        var operationsPerformed: Int
    )

    private fun throwToMonkey(monkey: Monkey, monkeys: List<Monkey>) {

        repeat(monkey.items.count()) {
            if (monkeyGetsBored(monkey) % monkey.divisibleBy == 0) {
                monkeys[monkey.actionIsTrue].items.addLast(monkeyGetsBored(monkey))
                monkey.items.removeFirst()
                monkey.operationsPerformed++
            } else {
                monkeys[monkey.actionIsFalse].items.addLast(monkeyGetsBored(monkey))
                monkey.items.removeFirst()
                monkey.operationsPerformed++
            }
        }
    }

    private fun monkeyGetsBored(monkey: Monkey): Int {
        return calculateWorryLevel(monkey) / 3
    }

    private fun convertWorryMultiplier(monkey: Monkey): Int {
        return if (monkey.worryMultiplier == "old") monkey.items.first() else monkey.worryMultiplier.toInt()
    }

    private fun calculateWorryLevel(monkey: Monkey): Int {
        return when (monkey.operator) {
            "*" -> monkey.items.first() * convertWorryMultiplier(monkey)
            "/" -> monkey.items.first() / convertWorryMultiplier(monkey)
            "+" -> monkey.items.first() + convertWorryMultiplier(monkey)
            "-" -> monkey.items.first() - convertWorryMultiplier(monkey)
            else -> error("invalid operation")
        }
    }

    private fun getListOfItems(monkey: String): ArrayDeque<Int> {
        val worryMultiplier =
            monkey.lines()
                .find { it.trim().startsWith("Starting") }
                .let {
                    it!!.substring(18, it.length)
                        .split(",")
                        .map { it.trim().toInt() }
                }

        return ArrayDeque(worryMultiplier)
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