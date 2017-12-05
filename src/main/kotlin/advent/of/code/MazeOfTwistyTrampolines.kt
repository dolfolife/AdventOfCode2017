package advent.of.code

import java.io.File

fun calculateMaze(maze: MutableList<Int>): Int {
    var steps = 0
    var index = 0
    while(index < maze.size) {
        val currentIndex = index
        index += maze[index]
        maze[currentIndex] += if(maze[currentIndex] > 2) { -1 } else { 1 }

        steps++
    }

    return steps
}

fun main(args: Array<String>) {
    val fileToParse = File("src/main/resources/MazeInput")
    val maze = fileToParse
            .readLines()
            .map { it.toInt() }.toMutableList()
    println(calculateMaze(maze))
}