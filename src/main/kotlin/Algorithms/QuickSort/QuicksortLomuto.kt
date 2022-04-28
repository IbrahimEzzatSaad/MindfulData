package Algorithms.QuickSort

import swapAt

/*----------Lomuto Algorithm----------
Lomuto’s partitioning algorithm always chooses the last element as the pivot. Time
to look at how this works in code.

This function takes three arguments:
•  list is the list you are partitioning.
•  low and high set the range within the list you’ll partition. This range will get
smaller and smaller with every recursion.
The function returns the index of the pivot.

In the naive implementation of quicksort, you created three new lists and filtered the
unsorted lists three times. Lomuto’s algorithm performs the partitioning in place.
That’s much more efficient*/

fun <T : Comparable<T>> MutableList<T>.quicksortLomuto(low: Int, high: Int) {
  /*Here, you apply Lomuto’s algorithm to partition the list into two regions. You then
    recursively sort these regions. Recursion ends once a region has less than two elements.*/
  if (low < high) {
    val pivot = this.partitionLomuto(low, high)
    this.quicksortLomuto(low, pivot - 1)
    this.quicksortLomuto(pivot + 1, high)
  }
}

fun <T : Comparable<T>> MutableList<T>.partitionLomuto(
  low: Int,
  high: Int
): Int {
  val pivot = this[high] // 1-Set the pivot. Lomuto always chooses the last element as the pivot.

  var i = low /* 2-The variable i indicates how many elements are less than the pivot. Whenever
  you encounter an element that is less than the pivot, you swap it with the element at index i and increase i.*/
  for (j in low until high) { // 3-Loop through all the elements from low to high, but not including high since it’s the pivot.
    if (this[j] <= pivot) { // 4-Check to see if the current element is less than or equal to the pivot.
      this.swapAt(i, j) // 5-If it is, swap it with the element at index i and increase i.
      i += 1
    }
  }
  this.swapAt(i, high) // 6-Once done with the loop, swap the element at i with the pivot. The pivot always sits between the less and greater partitions.
  return i // 7-Return the index of the pivot.
}

