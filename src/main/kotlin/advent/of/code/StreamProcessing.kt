package advent.of.code

import java.io.File

enum class STATE {
    IN_GROUP,
    IN_GARBAGE
}

fun calculateStreamScore(stream: String): Pair<Int,Int> {
    var groupScore = 0
    var currentLevel = 0
    var currentState = STATE.IN_GROUP
    var index = 0
    var garbageAmount = 0
    while (index < stream.length) {
        when (currentState) {
            STATE.IN_GROUP -> {
                when (stream[index]) {
                    '{' -> {
                        index++
                        currentLevel++
                    }
                    '}' -> {
                        groupScore+= currentLevel
                        index++
                        currentLevel--
                    }
                    '<' -> {
                        index++
                        currentState = STATE.IN_GARBAGE
                    }
                    '>' -> {
                        index++
                        currentState = STATE.IN_GROUP
                    }
                    '!' -> {
                        index += 2
                    }
                    else -> index++
                }
            }
            STATE.IN_GARBAGE -> {
                when (stream[index]) {
                    '>' -> {
                        index++
                        currentState = STATE.IN_GROUP
                    }
                    '!' -> {
                      index += 2
                    }
                    else ->  {
                        index++
                        garbageAmount++
                    }
                }
            }
        }
    }
    return Pair(groupScore,garbageAmount)
}

fun main(args: Array<String>) {
    val fileToParse = File("src/main/resources/stream.txt")
    println(calculateStreamScore(fileToParse.readLines().first()))
}