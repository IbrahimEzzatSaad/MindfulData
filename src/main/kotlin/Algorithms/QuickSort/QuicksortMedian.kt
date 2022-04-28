package Algorithms.QuickSort

import swapAt

/*An ideal pivot would split the elements evenly between the less than and greater
than partitions. Choosing the first or last element of an already sorted list as a pivot
makes quicksort perform much like insertion sort, which results in a worst-case performance of O(n²).

One way to address this problem is by using the median of three pivot selection strategy.
Here, you find the median of the first, middle and last element in the list, and use that as a pivot.

This prevents you from picking the highest or lowest element in the list.*/
fun <T : Comparable<T>> MutableList<T>.quickSortMedian(low: Int, high: Int) {
  //Here, you find the median of this[low], this[center] and this[high] by sorting them. The median will end up at index center, which is what the function returns.
  if (low < high) {
    val pivotIndex = medianOfThree(low, high)
    this.swapAt(pivotIndex, high)
    val pivot = partitionLomuto(low, high)
    this.quicksortLomuto(low, pivot - 1)
    this.quicksortLomuto(pivot + 1, high)
  }
}

fun <T : Comparable<T>> MutableList<T>.medianOfThree(low: Int, high: Int): Int {
  val center = (low + high) / 2
  if (this[low] > this[center]) {
    this.swapAt(low, center)
  }
  if (this[low] > this[high]) {
    this.swapAt(low, high)
  }
  if (this[center] > this[high]) {
    this.swapAt(center, high)
  }
  return center
}
