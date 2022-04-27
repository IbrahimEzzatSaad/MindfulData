package Algorithms.HeapSort

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}

fun <T> Array<T>.swapAt(first: Int, second: Int) {
    val aux = this[first]
    this[first] = this[second]
    this[second] = aux
}

val ascending = Comparator { first: Int, second: Int ->
    when {
        first < second -> -1
        first > second -> 1
        else -> 0
    }
}