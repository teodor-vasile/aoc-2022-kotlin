package main.kotlin2023

import java.util.regex.Pattern

class Day002 {

    data class CubeGame(val gameNumber: Int, val red: Int, val green: Int, val blue: Int)

    fun part1(lines: List<String>): Int {
        val bag = CubeGame(0, 12, 13, 14)
        var counter = 0
        var badGames = 0
        var goodGames = 0
        val regexRed = """(\d+)\s+red""".toRegex()
        val regexGreen = """(\d+)\s+green""".toRegex()
        val regexBlue = """(\d+)\s+blue""".toRegex()
        val regexGameNumber = """Game (\d+)""".toRegex()

        val matches = regexBlue.findAll(lines[0])
        val map = matches.map {
            it.groups[1]?.value
        }

        for (line in lines) {
            val gameNumber = regexGameNumber.find(line)!!.groups[1]!!.value.toInt()
            if (
                regexRed.findAll(line)
                    .any { it.groups[1]!!.value.toInt() > bag.red }
            ) {
                counter++
                badGames += gameNumber
                continue
            }

            if (
                regexGreen.findAll(line)
                    .any { it.groups[1]!!.value.toInt() > bag.green }
            ) {
                counter++
                badGames += gameNumber
                continue
            }
            if (
                regexBlue.findAll(line)
                    .any { it.groups[1]!!.value.toInt() > bag.blue }
            ) {
                counter++
                badGames += gameNumber
                continue
            } else {
                goodGames += gameNumber
            } }

        return goodGames
    }

//    fun part2(lines: List<String>): String {
//        val numberOfContainers = lines.first { it.trim().startsWith("1") }.trim().last().digitToInt()
//        val containers = List(numberOfContainers) { ArrayDeque<Char>() }.toMutableList()
//
//        createContainers(lines, containers)
//
//        val instructions: List<Instruction> = getInstructions(lines)
//
//        instructions.forEach { instr ->
//            containers[instr.target - 1].addAll(0, containers[instr.source - 1].take(instr.count))
//            repeat(instr.count) { containers[instr.source - 1].removeFirst() }
//        }
//
//        return containers.map { it.first() }.joinToString("")
//    }

    private fun getCubeGames(lines: List<String>): List<CubeGame> {
        val regex =
            """Game (\d+): (\d+) blue, (\d+) red; (\d+) red, (\d+) green, (\d+) blue; (\d+) green""".toRegex()
        val patternBlue = Pattern.compile("(\\d+)\\s+blue")
        val instructions = lines
            .map { it.split(';') }
//            .map {
//                val matchResult = regex.find(it)
//                val (gameNumber, red, green, blue) = matchResult!!.destructured
//                CubeGame(gameNumber.toInt(), red.toInt(), green.toInt(), blue.toInt())
//            }
        return listOf(CubeGame(1, 1, 1, 1))
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
