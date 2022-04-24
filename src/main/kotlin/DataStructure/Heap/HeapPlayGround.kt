package DataStructure.Heap

import example

fun main(){

    "Max-Heap" example{
    //this code in order to create a max-heap of Comparable objects represented by Int values.
        val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7) // 1-create an ArrayList of Ints
        val priorityQueue = ComparableHeapImpl.create(array) // 2-using the array in order to create a ComparableHeapImpl
        while (!priorityQueue.isEmpty) { // 3-remove and print the max value until the Heap is empty
            println(priorityQueue.remove())
        }
    }





    "create a min-heap" example{
        val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7) // 1-create an ArrayList of Ints
        val inverseComparator = object : Comparator<Int> { // 2-create an implementation of the Comparator<Int> which implements the inverse order for Int
            override fun compare(o1: Int, o2: Int): Int =
                o2.compareTo(o1)
        }
        val minHeap = ComparatorHeapImpl.create(array,
            inverseComparator) // 3-using the array and the comparator in order to create a ComparatorHeapImpl
        while (!minHeap.isEmpty) { // 4-remove and print the value with highest priority (whose value this time is the lowest) until the Heap is empty
            println(minHeap.remove())
        }
    }

}





/*----------Challenge 1: Find the nth smallest value---------
* Write a function to find the nth smallest integer in an unsorted array.
* --------------Solution-------------
* There are many ways to solve for the nth smallest integer in an unsorted array. For
example, you could choose a sorting algorithm you learned in this chapter, sort the
array, and grab the element at the nth index.

* Building a heap takes O(n). Every element removal from the heap takes O(log n).
Keep in mind that you’re also doing this n times. The overall time complexity is O(n
log n).*/
fun getNthSmallestElement(n: Int, elements: ArrayList<Int>): Int? {
    if (n <= 0 || elements.isEmpty()) return null

    val heap = ComparableHeapImpl.create(arrayListOf<Int>())

    elements.forEach {
        val maxElement = heap.peek()
        if (heap.count < n) {
            heap.insert(it)
        } else if (maxElement != null && maxElement > it) {
            heap.remove()
            heap.insert(it)
        }
    }

    return heap.peek()
}