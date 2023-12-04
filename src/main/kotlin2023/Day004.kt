package main.kotlin2023

class Day004 {

    data class Instruction(val count: Int, val source: Int, val target: Int)

    fun part1(lines: List<String>): Int {
        val objects = lines.map { line ->
            line.dropWhile { it != ':' }
                .split('|')
                .map { subString ->
                    subString.split(' ')
                        .filter { it.isNotEmpty() && it.all(Character::isDigit) }
                        .map(String::toInt)
                }
        }

        val sumOf = objects.map { it[0].intersect(it[1]).size }
            .filter { !it.equals(0) }
            .sumOf { Math.pow(2.0, (it - 1).toDouble()) }.toInt()

        return sumOf
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
