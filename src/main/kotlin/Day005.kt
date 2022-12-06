class Day005 {

    fun part1(lines: List<String>): String {

        // get the number of containers
        val numberOfContainers = lines.first { it.trim().startsWith("1") }.trim().last().digitToInt()
        // create containers
        val containers = List(numberOfContainers) { ArrayDeque<Char>() }

        lines
            .takeWhile { !it.trim().startsWith("1") }
            .map { line ->
                line.slice(1..line.length step 4)
                    .mapIndexed { containerNumber, value ->
                        if (value.isLetter()) containers[containerNumber].addLast(value)
                    }
            }

        // get instructions out
        data class Instruction(val count: Int, val source: Int, val target: Int)

        val regex = """move (\d+) from (\d+) to (\d+)""".toRegex()
        val instructions: List<Instruction> = lines
            .dropWhile { !it.trim().startsWith("move") }
            .map {
                val matchResult = regex.find(it)
                val (count, source, target) = matchResult!!.destructured
                Instruction(count.toInt(), source.toInt(), target.toInt())
            }

        println("Before ----------")
        containers.forEach { println(it) }
        println(containers.size)
        instructions.forEach { println(it) }
        instructions.forEach {
                println(it)
            for (i in 1..it.count) {
                if (containers[it.source - 1].isNotEmpty())
                containers[it.target - 1].addFirst(containers[it.source - 1].removeFirst())
            println(containers.forEach { println(it) })
                println(containers.size)
            }
        }
        println("After ----------")

        containers.forEach { println(it) }

        containers.forEach {
            println(it.first())

        }

        val str =
            containers.map{
                it.first()
            }
                .joinToString ("")

        return str
    }

}

