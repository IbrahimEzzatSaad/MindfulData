package Algorithms.MergeSort

/*---------------------Key Points-----------------------
* Merge sort is in the category of the divide and conquer algorithms.
* There are many implementations of merge sort, and you can have different
performance characteristics depending on the implementation.
* To do a comparison, in this chapter you sorted objects implementing the
Comparable<T> interface but the same can be done providing a different implementation of Comparator<T>.*/

fun main() {

    "merge sort" example {
        val list = listOf(7, 2, 6, 3, 9)
        println("Original: $list")

        val result = list.mergeSort()
        println("Merge sorted: $result")
    }

    "merge iterables" example {
        val list1 = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val list2 = listOf(1, 3, 4, 5, 5, 6, 7, 7)

        val result = merge(list1, list2)
        println("Merged: $result")
    }

}