package Algorithms.On2Sorting.challenges

import swapAt

/*---------Challenge 1: To the left, to the left---------
* Given a list of Comparable elements, bring all instances of a given value in the list to the right side of the array.
* ---------------Solution-----------------
* The trick to this problem is to find the elements that need to be moved and shift
  everything else to the left. Then, return to the position where the element was before, and continue searching from there.
* The time complexity of this solution is O(n).*/
fun <T : Comparable<T>> MutableList<T>.rightAlign(element: T) {
  // 1-If there are less than two elements in the list, there’s nothing to do.
  if (this.size < 2) return
  /* 2-You leave the last element alone and start from the previous one. Then, you go to
       the left (decreasing the index), until you reach the beginning of the list when the searchIndex is 0.*/
  var searchIndex = this.size - 2
  while (searchIndex >= 0) {
    // 3-You’re looking for elements that are equal to the one in the function parameter.
    if (this[searchIndex] == element) {
      /* 4-Whenever you find one, you start shifting it to the right until you reach another
          element equal to it or the end of the list. Remember, you already implemented swapAt(); don’t forget to increment moveIndex.*/
      var moveIndex = searchIndex
      while (moveIndex < this.size - 1 && this[moveIndex + 1] != element) {
        swapAt(moveIndex, moveIndex + 1)
        moveIndex++
      }
    }
    // 5-After you’re done with that element, move searchIndex to the left again by decrementing it.
    searchIndex--
  }
}
