package Algorithms.MergeSort

/*Merge sort is one of the most efficient sorting algorithms. With a time complexity of
O(n log n), it’s one of the fastest of all general-purpose sorting algorithms. The idea
behind merge sort is divide and conquer — to break a big problem into several
smaller, easier-to-solve problems, and then combine those solutions into a final
result. The merge sort mantra is to split first and merge after.

Example: https://www.youtube.com/watch?v=JSceec-wEyw

Here’s a summary of the key procedures of merge sort:
    1.The strategy of merge sort is to divide and conquer so that you solve many small problems instead of one big problem.
    2.It has two core responsibilities: a method to divide the initial list recursively, as well as a method to merge two lists.
    3.The merging function should take two sorted lists and produce a single sorted list.

    ----------Performance----------
    The best, worst and average time complexity of merge sort is O(n log n), which isn’t
    too bad. If you’re struggling to understand where n log n comes from, think about how the recursion works:
    * As you recurse, you split a single list into two smaller lists. This means a list of size
        2 will need one level of recursion, a list of size 4 will need two levels, a list of size 8
        will need three levels, and so on. If you had a list of 1,024 elements, it would take
        10 levels of recursively splitting in two to get down to 1024 single element lists. In
        general, if you have a list of size n, the number of levels is log2(n).
    * A single recursion level will merge n elements. It doesn’t matter if there are many
        small merges or one large one; the number of elements merged will still be n at
        each level. This means the cost of a single recursion is O(n).
        This brings the total cost to O(log n) ×O(n) = O(n log n).*/
fun <T : Comparable<T>> List<T>.mergeSort(): List<T> {
    /*1-Recursion needs a base case, which you can also think of as an “exit condition”.
      In this case, the base case is when the list only has one element. Your previous
      quick win is now the cornerstone of the algorithm.*/
    if (this.size < 2) return this
    val middle = this.size / 2
    /*2-You’re calling mergeSort on each of the sub-lists. This recursion continues to try
        to split the lists into smaller lists until the “exit condition” is fulfilled.
        In your case, it will split until the lists contain only one element.*/
    val left = this.subList(0, middle).mergeSort()
    val right = this.subList(middle, this.size).mergeSort()

    return merge(left, right)
}

private fun <T : Comparable<T>> merge(left: List<T>, right: List<T>): List<T> {
    // 1-The leftIndex and rightIndex variables track your progress as you parse through the two lists.
    var leftIndex = 0
    var rightIndex = 0
    // 2-The result list will house the combined lists.
    val result = mutableListOf<T>()
    /* 3-Starting from the beginning, you compare the elements in the left and right lists sequentially.
     When you reach the end of either list, there’s nothing else to compare.*/
    while (leftIndex < left.size && rightIndex < right.size) {
        val leftElement = left[leftIndex]
        val rightElement = right[rightIndex]
        // 4-The smaller of the two elements goes into the result list. If the elements are equal, they can both be added.
        if (leftElement < rightElement) {
            result.add(leftElement)
            leftIndex += 1
        } else if (leftElement > rightElement) {
            result.add(rightElement)
            rightIndex += 1
        } else {
            result.add(leftElement)
            leftIndex += 1
            result.add(rightElement)
            rightIndex += 1
        }
    }
    /*5-The first loop guarantees that either left or right is empty. Since both lists are
        sorted, this ensures that the leftover elements are greater than or equal to the
        ones currently in result. In this scenario, you can add the rest of the elements without comparison.*/
    if (leftIndex < left.size) {
        result.addAll(left.subList(leftIndex, left.size))
    }
    if (rightIndex < right.size) {
        result.addAll(right.subList(rightIndex, right.size))
    }
    return result
}