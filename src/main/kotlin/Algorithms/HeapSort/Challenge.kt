package Algorithms.HeapSort

/*---------------Challenge 2: Descending sort-----------------
  The current example of heap sort sorts the elements in **ascending** order. How would you sort in **descending** order?
  -----------------Solution-----------------
    You just need to swap the ascending comparator with a
    descending one when you create the SortingHeap. Looking at how ascending is
    defined, you can easily come up with a descending:*/

val descending = Comparator { first: Int, second: Int ->
    when {
        first < second -> 1
        first > second -> -1
        else -> 0
    }
}