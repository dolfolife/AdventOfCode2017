package advent.of.code

import java.io.File

//https://adventofcode.com/2017/day/2

fun Collection<Collection<Int>>.checkSum(): Int =
        this.map {
            it.fold(Pair(it.first(), it.last())) { values, nextValue ->
                when (true) {
                    nextValue < values.first -> Pair(nextValue, if (values.first < values.second) values.second else values.first)
                    nextValue > values.second -> Pair(if (values.first > values.second) values.second else values.first, nextValue)
                    else -> values
                }
            }
        }.map { it.second - it.first }.sum()


private fun Collection<Int>.findDivision(): Int =
    this.map { i ->
        this.fold(0) { result, j ->
            if (i % j == 0 && i != j) {
                return i.div(j)
            } else result
        }
    }.first()

fun Collection<Collection<Int>>.checkEvenSum(): Int =
        this.map { it.findDivision() }.sum()

fun main(args: Array<String>) {
    val fileToParse = File("src/main/resources/CorruptionChecksumData.txt")
    val file = fileToParse
            .readLines()
            .map { it.split(" ").map { it.toInt() } }
    println(file.checkSum())
    println(file.checkEvenSum())
}