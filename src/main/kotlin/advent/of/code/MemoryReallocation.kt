package advent.of.code

data class Solution(val found: List<Int>, val result: Int)

fun whenIsTheNextCycle(blocks: List<Int>): Solution {
    var steps = 0
    val  state = mutableSetOf<List<Int>>()

    var currentState = blocks
    while(!state.contains(currentState)) {
        state.add(currentState)
        val tempState = currentState.toMutableList()
        var max = currentState.max() ?: 0
        var startIndex = currentState.indexOf(max)
        tempState[startIndex] = 0
        while(max > 0) {
            if(startIndex < currentState.size - 1) {
                startIndex++
            } else { startIndex = 0 }
            tempState[startIndex] +=1
            max--
        }
        currentState = tempState.toList()
        steps++
    }
    return Solution(found= currentState, result = steps)
}

fun main(args: Array<String>) {
    val input = listOf(14,0,15,12,11,11,3,5,1,6,8,4,9,1,8,4)
    val solution = whenIsTheNextCycle(input)

    println("part 1 - ${solution.result}")
    println("part 2 - ${whenIsTheNextCycle(solution.found).result}")

}
