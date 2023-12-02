package main.kotlin2023

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
            }
        }

        return goodGames
    }

    fun part2(lines: List<String>): Int {
        var counter = 0
        var red = 0
        var green = 0
        var blue = 0
        val regexRed = """(\d+)\s+red""".toRegex()
        val regexGreen = """(\d+)\s+green""".toRegex()
        val regexBlue = """(\d+)\s+blue""".toRegex()

        for (line in lines) {
            red = regexRed.findAll(line)
                .maxOf { it.groups[1]!!.value.toInt() }
            green = regexGreen.findAll(line)
                .maxOf { it.groups[1]!!.value.toInt() }
            blue = regexBlue.findAll(line)
                .maxOf { it.groups[1]!!.value.toInt() }

            counter += red * green * blue
        }

        return counter
    }
}
