package Algorithms.On2Sorting.bubblesort

import swapAt

/*Bubble sort has a best time complexity of O(n) if it’s already sorted, and a worst and
          average time complexity of O(n²), making it one of the least appealing sorts.

 Example of Bubble sort : https://www.resultswebdev.com/wp-content/themes/results-website-design/uploads/bubble-sort-animation2.gif */
fun <T : Comparable<T>> MutableList<T>.bubbleSort(showPasses: Boolean = false) {
  /*1-There’s no need to sort the collection when it has less than two elements.
   One element is sorted by itself; zero elements don’t require an order.*/
  if (this.size < 2) return
  /* 2-A single-pass will bubble the largest value to the end of the collection. Every pass
      needs to compare one less value than in the previous pass, so you shorten the array by one with each pass.*/
  for (end in this.lastIndex downTo 1) {
    var swapped = false
    /* 3-This loop performs a single pass starting from the first element and going up
    until the last element not already sorted. It compares every element with the adjacent value.*/
    for (current in 0 until end) {
      if (this[current] > this[current + 1]) {
        /* 4-Next, the algorithm swaps the values if needed and marks this in swapped. This is
          important later because it’ll allow you to exit the sort as early as you can detect the list is sorted.*/
        this.swapAt(current, current + 1)
        swapped = true
      }
    }
    /* 5-This prints out how the list looks after each pass. This step has nothing to do
      with the sorting algorithm, but it will help you visualize how it works. You can
      remove it (and the function parameter) after you understand the sorting algorithm.*/
    if(showPasses) println(this)
    // 6-If no values were swapped this pass, the collection is assumed sorted, and you can exit early.
    if (!swapped) return
  }
}

