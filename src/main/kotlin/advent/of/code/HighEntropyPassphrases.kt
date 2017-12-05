package advent.of.code

import java.io.File

fun List<List<String>>.findValidPassphrases(): List<List<String>> = this
        .filter { it.distinct().size == it.size }
        .filter { listOfWords -> listOfWords.all { it.anyAnagram(listOfWords) } }

fun String.anyAnagram(words: List<String>): Boolean = words.
        filterNot { it.equals(this, ignoreCase = true) }
        .none { it.toSortedLowerCase() == this.toSortedLowerCase() }

fun String.toSortedLowerCase(): List<Char> = this.toLowerCase().toList().sorted()

fun main(args: Array<String>) {
    val fileToParse = File("src/main/resources/Passphrases")
    val listOfPassphrases = fileToParse
            .readLines()
            .map { it.split(" ") }

    println(listOfPassphrases.findValidPassphrases().size)
}