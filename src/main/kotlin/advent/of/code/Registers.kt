package advent.of.code

import java.io.File

data class Registry(
        val name: String,
        var value: Int = 0
)

fun calculateRegisters(fileName: String): Pair<Set<Registry>, Int> {
    var maxValue = 0
    var registries = setOf<Registry>()
    File(fileName)
            .readLines()
            .map { instructionLine ->
                val instructionAndConditional = instructionLine.split(" if ")
                val instruction = instructionAndConditional.first().split(" ")
                val conditional = instructionAndConditional.last().split(" ")
                registries = registries
                        .plus(Registry(name = instruction.first()))
                        .plus(Registry(name = conditional.first()))
                if (instructionCheck(conditional, registries))
                    registries.find { instruction.first() == it.name }?.apply {
                        value = when (instruction[1]) {
                            "inc" -> {
                                val newValue = value + instruction.last().toInt()
                                maxValue = if(newValue > maxValue) newValue else maxValue
                                newValue
                            }
                            else -> {
                                val newValue = value - instruction.last().toInt()
                                maxValue = if(newValue > maxValue) newValue else maxValue
                                newValue
                            }
                        }
                    }
            }

    return Pair(registries, maxValue)
}

private fun instructionCheck(conditional: List<String>, registries: Set<Registry>): Boolean {
    return when (conditional[1]) {
        ">" -> registries.find { conditional.first() == it.name }?.value ?: 0 > conditional.last().toInt()
        ">=" -> registries.find { conditional.first() == it.name }?.value ?: 0 >= conditional.last().toInt()
        "<" -> registries.find { conditional.first() == it.name }?.value ?: 0 < conditional.last().toInt()
        "<=" -> registries.find { conditional.first() == it.name }?.value ?: 0 <= conditional.last().toInt()
        "==" -> registries.find { conditional.first() == it.name }?.value ?: 0 == conditional.last().toInt()
        "!=" -> registries.find { conditional.first() == it.name }?.value ?: 0 != conditional.last().toInt()
        else -> false
    }
}

fun main(args: Array<String>) {
    val file = "src/main/resources/instructions.txt"

    val registries = calculateRegisters(file)

    println("part 1 - ${registries.first.maxBy { it.value }?.value}")
    println("part 2 - ${registries.second}")
}