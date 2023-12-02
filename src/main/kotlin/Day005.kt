class Day005 {

    data class Instruction(val count: Int, val source: Int, val target: Int)

    fun part1(lines: List<String>): String {
        val numberOfContainers = lines.first { it.trim().startsWith("1") }.trim().last().digitToInt()

        val containers = List(numberOfContainers) { ArrayDeque<Char>() }
        createContainers(lines, containers as MutableList<ArrayDeque<Char>>)

        val instructions: List<Instruction> = getInstructions(lines)

        instructions.forEach { instruction ->
            repeat(instruction.count) {
                if (containers[instruction.source - 1].isNotEmpty()) {
                    containers[instruction.target - 1].addFirst(containers[instruction.source - 1].removeFirst())
                }
            }
        }

        return containers.map { it.first() }.joinToString("")
    }

    fun part2(lines: List<String>): String {
        val numberOfContainers = lines.first { it.trim().startsWith("1") }.trim().last().digitToInt()
        val containers = List(numberOfContainers) { ArrayDeque<Char>() }.toMutableList()

        createContainers(lines, containers)

        val instructions: List<Instruction> = getInstructions(lines)

        instructions.forEach { instr ->
            containers[instr.target - 1].addAll(0, containers[instr.source - 1].take(instr.count))
            repeat(instr.count) { containers[instr.source - 1].removeFirst() }
        }

        return containers.map { it.first() }.joinToString("")
    }

    private fun getInstructions(lines: List<String>): List<Instruction> {
        val regex = """move (\d+) from (\d+) to (\d+)""".toRegex()
        val instructions: List<Instruction> = lines
            .dropWhile { !it.trim().startsWith("move") }
            .map {
                val matchResult = regex.find(it)
                val (count, source, target) = matchResult!!.destructured
                Instruction(count.toInt(), source.toInt(), target.toInt())
            }
        return instructions
    }

    private fun createContainers(
        lines: List<String>,
        containers: MutableList<ArrayDeque<Char>>,
    ) {
        lines
            .takeWhile { !it.trim().startsWith("1") }
            .map { line ->
                line.slice(1..line.length step 4)
                    .mapIndexed { containerNumber, value ->
                        if (value.isLetter()) containers[containerNumber].addLast(value)
                    }
            }
    }
}
