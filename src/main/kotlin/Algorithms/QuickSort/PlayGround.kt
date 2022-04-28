package Algorithms.QuickSort

/*Quicksort is another comparison-based sorting algorithm. Much like merge sort, it
uses the same strategy of divide and conquer. One important feature of quicksort is
choosing a pivot point. The pivot divides the list into three partitions

------------------Challenge 2: Provide an explanation---------------
Explain when and why you would use merge sort over quicksort.
-----------------Solution----------------
• Merge sort is preferable over quicksort when you need stability. Merge sort is a
stable sort and guarantees O(n log n). This is not the case with quicksort, which isn’t stable and can perform as bad as O(n²).

• Merge sort works better for larger data structures or data structures where
elements are scattered throughout memory. Quicksort works best when elements are stored in a contiguous block.


----------------------Key Points----------------------
* The naive partitioning creates a new list on every filter function; this is inefficient. All other strategies sort in place.
* Lomuto’s partitioning chooses the last element as the pivot.
* Hoare’s partitioning chooses the first element as its pivot.
* An ideal pivot would split the elements evenly between partitions.
* Choosing a bad pivot can cause quicksort to perform in O(n²).
* Median of three finds the pivot by taking the median of the first, middle and last element.
* Dutch national flag partitioning strategy helps to organize duplicate elements in a more efficient way.*/
fun main() {

    "Naive quicksort" example  {
        val list = arrayListOf(12, 0, 3, 9, 2, 18, 8, 27, 1, 5, 8, -1, 21)
        println("Original: $list")
        val sorted = list.quicksortNaive()
        println("Sorted: $sorted")
    }
    "Lomuto quicksort" example  {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quicksortLomuto(0, list.size - 1)
        println("Sorted: $list")
    }
    "Hoare quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quicksortHoare( 0, list.size - 1)
        println("Sorted: $list")
    }
    "Median of three quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quickSortMedian( 0, list.size - 1)
        println("Sorted: $list")
    }
    "Dutch flag quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quicksortDutchFlag( 0, list.size - 1)
        println("Sorted: $list")
    }
    "Iterative Lomuto quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quicksortIterativeLomuto( 0, list.size - 1)
        println("Sorted: $list")
    }

}