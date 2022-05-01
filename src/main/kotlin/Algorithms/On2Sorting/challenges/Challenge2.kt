package Algorithms.On2Sorting.challenges

import Algorithms.On2Sorting.selectionsort.selectionSort

/*-----------Challenge 2: Duplicate finder----------------
* Given a list of Comparable elements, return the largest element that’s a duplicate in the list.
* --------------Solution--------------
* Finding the biggest duplicated element is rather straightforward. To make it even easier,
* you can sort the list with one of the methods you’ve already implemented.
* The time complexity of this solution is O(n²) because you’ve used sorting.*/
fun <T : Comparable<T>> MutableList<T>.biggestDuplicate(): T? {
  //1-You first sort the list.
  this.selectionSort()
  //2-Start going through it from right to left since you know that the biggest elements are on the right, neatly sorted.
  for (i in this.lastIndex downTo 1) {
    //3-The first one that’s repeated is your solution
    if (this[i] == this[i - 1]) {
      return this[i]
    }
  }
  return null
}
