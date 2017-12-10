package advent.of.code

import java.io.File

data class Program(
        val name: String,
        val diskUsage: Int,
        val children: List<String>,
        var root: Boolean = true
)

val emptyProgram = Program(
        name = "",
        diskUsage = 0,
        children = listOf()
)

private fun String.toProgram(): Program = this
        .split(" ")
        .let {
            Program(
                    name = it.first(),
                    diskUsage = it[1].substring(1, it[1].length - 1).toInt(),
                    children = if (it.size > 3)
                        it.subList(3, it.size).map { it.replace(',', ' ').trim() }
                    else listOf()
            )
        }

fun List<Program>.addChildren(program: Program): List<Program> = this
        .map {
            it.apply {
                root = !program.children.contains(this.name) && root
            }
        }
        .plus(program.apply {
            root = !this@addChildren.any { it.name == program.name || it.children.contains(program.name) }
        })

fun calculateRoots(fileName: String): List<Program> =
        File(fileName).readLines()
                .map { it.toProgram() }
                .fold(listOf()) { acc, current ->
                    acc.addChildren(current)
                }


fun calculateDiskUsageOf(programName: String, list: List<Program>): Pair<Program, Int> = list
        .find { it.name == programName }
        ?.let {
            Pair(it, it.diskUsage + it.children.map { calculateDiskUsageOf(it, list) }.map { it.second }.sum())
        }
        ?: Pair(emptyProgram, 0)

fun calculateNewBalance(list: List<Program>, elem: Program, correction: Int): Int = elem
        .let {
            val diskUsage = it.children.map { calculateDiskUsageOf(it, list) }
            val badTower = diskUsage.filter { disk -> diskUsage.none { it.first != disk.first && it.second == disk.second } }
            val goodTowers = diskUsage.filter { disk -> diskUsage.any { it.first != disk.first && it.second == disk.second } }
            if (badTower.isEmpty())
                elem.diskUsage + correction
            else
                calculateNewBalance(
                        list = list,
                        elem = badTower.first().first,
                        correction = goodTowers.first().second - badTower.first().second
                )
        }

fun calculateBalanceWeight(list: List<Program>): Int = list
        .first { it.root }
        .let { calculateNewBalance(list, it, 0) }

fun main(args: Array<String>) {
    val programs = calculateRoots("src/main/resources/RecursiveCircus.txt")
    println("Part 1 ${programs.first { it.root }.name}")
    println("Part 2 ${calculateBalanceWeight(programs)}")
}