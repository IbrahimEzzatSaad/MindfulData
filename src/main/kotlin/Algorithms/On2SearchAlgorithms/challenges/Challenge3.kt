package Algorithms.On2SearchAlgorithms.challenges

import swapAt

/*-----------------Challenge 3: Manual reverse-----------------
* Reverse a list of elements by hand. Do not rely on reverse or reversed; you need to create your own.
* --------------------Solution---------------------
* Reversing a collection is also quite straightforward. Using the double reference
approach, you start swapping elements from the start and end of the collection, making your way to the middle.
* Once you’ve hit the middle, you’re done swapping, and the collection is reversed.
* For this solution, you need MutableList since you need to mutate the collection to reverse.
* The time complexity of this solution is O(n).*/
fun <T : Comparable<T>> MutableList<T>.rev() {
  var left = 0
  var right = this.lastIndex

  while (left < right) {
    swapAt(left, right)
    left++
    right--
  }
}
