package Algorithms.QuickSort


/*------------------Challenge 1: Using recursion-----------------
*  Your challenge is to implement quicksort iteratively.
* -----------------Solution------------------
* You implemented quicksort recursively, which means you know what quicksort is all
about. So, how you might do it iteratively? This solution uses Lomuto’s partition strategy.

* This function takes in a list and the range between low and high. You’re going to
leverage the stack to store pairs of start and end values.
* You’re simply using the stack to store a pair of start and end indices to perform the partitions.*/
fun <T : Comparable<T>> MutableList<T>.quicksortIterativeLomuto(low: Int, high: Int) {
    val stack = stackOf<Int>() // 1-Create a stack that stores indices.
    stack.push(low) // 2-Push the starting low and high boundaries on the stack to initiate the algorithm.
    stack.push(high)

    while (!stack.isEmpty) { // 3-As long as the stack is not empty, quicksort is not complete.
        // 4-Get the pair of start and end indices from the stack.
        val end = stack.pop() ?: continue
        val start = stack.pop() ?: continue

        /*5-Perform Lomuto’s partitioning with the current start and end index. Recall that
            Lomuto picks the last element as the pivot, and splits the partitions into three
            parts: elements that are less than the pivot, the pivot, and finally elements that are greater than the pivot.*/
        val p = this.partitionLomuto(start, end)
        if ((p - 1) > start) {    // 6-Once the partitioning is complete, check and add the lower bound’s start and end indices to later partition the lower half.
            stack.push(start)
            stack.push(p - 1)
        }
        if ((p + 1) < end) {    // 7-Similarly, check and add the upper bound’s start and end indices to later partition the upper half.
            stack.push(p + 1)
            stack.push(end)
        }
    }
}