package Algorithms.On2Sorting.selectionsort

import swapAt

/*Selection sort follows the basic idea of bubble sort but improves upon this
algorithm by reducing the number of swapAt operations. Selection sort only swaps at
the end of each pass. You’ll see how that works in the following implementation.

Like bubble sort, selection sort has a worst and average time complexity of O(n²),
which is fairly dismal. Unlike the bubble sort, it also has the best time complexity of
O(n²). Despite this, it performs better than bubble sort because it performs only O(n)
swaps — and the best thing about it is that it’s a simple one to understand.
https://thumbs.gfycat.com/SnappyMasculineAmericancicada-size_restricted.gif */
fun <T : Comparable<T>> MutableList<T>.selectionSort(showPasses: Boolean = false) {
  if (this.size < 2) return
  /*1-You perform a pass for every element in the collection, except for the last one.
    There’s no need to include the last element because if all other elements are in their correct order, the last one will be as well.*/
  for (current in 0 until this.lastIndex) {
    var lowest = current
    // 2-In every pass, you go through the remainder of the collection to find the element with the lowest value.
    for (other in (current + 1) until this.size) {
      if (this[other] < this[lowest]) {
        lowest = other
      }
    }
    // 3-If that element is not the current element, swap them.
    if (lowest != current) {
      this.swapAt(lowest, current)
    }
    /*4-This optional step shows you how the list looks after each step when you call the function with showPasses set to true.
        You can remove this and the parameter once you understand the algorithm.*/
    if (showPasses) println(this)
  }
}
