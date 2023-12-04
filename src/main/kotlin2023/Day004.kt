package main.kotlin2023

import kotlin.math.pow

class Day004 {

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
            .sumOf { 2.0.pow(it - 1) }.toInt()

        return sumOf
    }
    fun part2(lines: List<String>): Int {
        data class Card(val winningNumbers: List<Int>, val ourNumbers: List<Int>)
        return lines.map { line ->
            val (_, winningNumbersText, ourNumbersText) = line.split(":", " | ")
            val winningNumbers = winningNumbersText.chunked(3).map { it.trim().toInt() }
            val ourNumbers = ourNumbersText.chunked(3).map { it.trim().toInt() }
            val count = winningNumbers.count { it in ourNumbers }
            Card(winningNumbers, ourNumbers)to count
        }.let { pairs ->
            val countByCard = MutableList(pairs.size) { 1 }
            pairs.mapIndexed { index, (_, count) ->
                (1..count).forEach {
                    countByCard[index + it] += countByCard[index]
                }
            }
            countByCard
        }
            .onEach(::println)
            .sum()
    }
}
