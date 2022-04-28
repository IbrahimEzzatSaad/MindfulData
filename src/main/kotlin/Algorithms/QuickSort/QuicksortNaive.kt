package Algorithms.QuickSort

/*This implementation recursively filters the list into three partitions.
* https://assets.alexandria.raywenderlich.com/books/dsk/images/e407b66b0f19f8609ea8de72706aa3ffb34177dccda604756c0273391f20b7cd/original.png
* Each level corresponds with a recursive call to quicksort. Once recursion stops, the
leafs are combined again, resulting in a fully sorted list

* While this naive implementation is easy to understand, it raises some issues and questions:
    •  Calling filter three times on the same list is not efficient?
    •  Creating a new list for every partition isn’t space-efficient. Could you possibly sort in place?
    •  Is picking the middle element the best pivot strategy? What pivot strategy should you adopt?*/
fun <T : Comparable<T>> List<T>.quicksortNaive(): List<T> {
  if (this.size < 2) return this // 1-There must be more than one element in the list. If not, the list is considered sorted.

  val pivot = this[this.size / 2] // 2-Pick the middle element of the list as your pivot.
  val less = this.filter { it < pivot } // 3-Using the pivot, split the original list into three partitions.  or greater than the pivot go into differElements less than,equal toent buckets.
  val equal = this.filter { it == pivot }
  val greater = this.filter { it > pivot }
  return less.quicksortNaive() + equal + greater.quicksortNaive() // 4-Recursively sort the partitions and then combine them.
}
