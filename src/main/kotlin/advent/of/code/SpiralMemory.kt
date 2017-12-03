package advent.of.code

fun calculateStepsFor(value: Int): Int {
    var maxDistance = 1
    while (maxDistance*maxDistance < value) {
        maxDistance+=2
    }

    if(maxDistance == 1) return 0

    var difference = (maxDistance * maxDistance - value) % (maxDistance - 1)
    difference = if (difference > ((maxDistance - 1)/2)) {
        (difference - ((maxDistance - 1)/2)) - ((maxDistance - 1)/2)
    } else { -1*difference }
    return maxDistance - 1 + difference
}

// Second part is a well-known sequence https://oeis.org/A141481

fun main(args: Array<String>) {
    println(calculateStepsFor(368078))
}