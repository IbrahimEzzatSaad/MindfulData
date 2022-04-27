package Algorithms.HeapSort


/*Heapsort is another comparison-based algorithm that sorts an array in ascending
order using a heap.
Heapsort takes advantage of a heap being, by definition, a partially sorted binary tree
with the following qualities:
1. In a max heap, all parent nodes are larger than their children.
2. In a min heap, all parent nodes are smaller than their children.

Ex: https://www.youtube.com/watch?v=MtQL_ll5KhQ

You'll be performing the sort on an Array and reusing the algorithms already
implemented in Heap in the form of extension functions. You'll reorder the elements
using heapify(). After that, the heavy lifting will be done by a siftDown() method.


Even though you get the benefit of in-memory sorting, the performance of heap sort
is O(n log n) for its best, worse and average cases. This is because you have to
traverse the whole array once and, every time you swap elements, you must perform
a sift down, which is an O(log n) operation.

Heap sort is also not a stable sort because it depends on how the elements are laid
out and put into the heap. If you were heap sorting a deck of cards by their rank, for
example, you might see their suite change order with respect to the original deck.

----------------Key Points------------------
* Heap sort leverages the max-heap data structure to sort elements in an array.
* Heap sort sorts its elements by following a simple pattern: swap the first and last
element, perform a sift-down, decrease the array size by one; then repeat.
* The performance of heap sort is O(n log n) for its best, worse and average cases.*/


private fun leftChildIndex(index: Int) = (2 * index) + 1

private fun rightChildIndex(index: Int) = (2 * index) + 2


/*The differences between this function and the method that the Heap has is that you
operate on this array instead of elements, and that your compare() calls are
addressed to the comparator you get as a parameter. The algorithm itself remains
the same, so if you can't wrap your head around this, you can take a look at the Heap Data Structure again*/
fun <T : Any> Array<T>.siftDown(
    index: Int,
    upTo: Int,
    comparator: Comparator<T>,
) {
    var parent = index
    while (true) {
        val left = leftChildIndex(parent)
        val right = rightChildIndex(parent)
        var candidate = parent
        if (left < upTo &&
            comparator.compare(this[left], this[candidate]) > 0
        ) {
            candidate = left
        }
        if (right < upTo &&
            comparator.compare(this[right], this[candidate]) > 0
        ) {
            candidate = right
        }
        if (candidate == parent) {
            return
        }
        this.swapAt(parent, candidate)
        parent = candidate
    }
}

fun <T : Any> Array<T>.heapify(comparator: Comparator<T>) {
    if (this.isNotEmpty()) {
        (this.size / 2 downTo 0).forEach {
            this.siftDown(it, this.size, comparator)
        }
    }
}

fun <T : Any> Array<T>.heapSort(comparator: Comparator<T>) {
    this.heapify(comparator) // 1-You reorder the elements so that the array looks like a Heap.
    for (index in this.indices.reversed()) { // 2-You loop through the array, starting from the last element.
        this.swapAt(0, index) // 3-You swap the first element and the last element. This moves the largest unsorted element to its correct spot.
        siftDown(0, index, comparator) // 4-Because the heap is now invalid, you must sift down the new root node. As a result, the next largest element will become the new root.
    }
}