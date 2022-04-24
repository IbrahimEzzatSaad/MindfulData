package Algorithms.On2SearchAlgorithms.insertionsort

import swapAt

/*Insertion sort is a more useful algorithm. Like bubble sort and selection sort,
insertion sort has an average time complexity of O(n²), but the performance of
insertion sort can vary. The more the data is already sorted, the less work it needs to
do. Insertion sort has a best time complexity of O(n) if the data is already sorted.

Insertion sort is one of the fastest sorting algorithms when some of the data is
already sorted, but this isn’t true for all sorting algorithms. In practice, a lot of data
collections will already be mostly — if not entirely — sorted, and an insertion sort
will perform quite well in those scenarios.*/
fun <T : Comparable<T>> MutableList<T>.insertionSort(showPasses: Boolean = false) {
  if (this.size < 2) return
  // 1-Insertion sort requires you to iterate from left to right, once. This loop does that.
  for (current in 1 until this.size) {
    // 2-Here, you run backward from the current index so you can shift left as needed.
    for (shifting in current downTo 1) {
      /*3-Keep shifting the element left as long as necessary. As soon as the element is in
          position, break the inner loop and start with the next element.*/
      if (this[shifting] < this[shifting - 1]) {
        this.swapAt(shifting, shifting - 1)
      } else {
        break
      }
    }
    /*4-This is the same trick you used with the other sort algorithms; it shows you the
        passes. Remember that this is not part of the sorting algorithm.*/
    if(showPasses) println(this)
  }
}
