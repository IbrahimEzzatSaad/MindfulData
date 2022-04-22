package DataStructure.Heap

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


/*  A heap is a complete binary tree data structure also known as a binary heap that
    you can construct using an array.

    Heaps come in two flavors:
    1. Maxheap, in which elements with a higher value have a higher priority.
    2.   Minheap, in which elements with a lower value have a higher priority.

Note: It's important to say that the concept of heap is valid for every type of object that can be compared to others of the same type. In this chapter you'll
see mostly Ints but the same concepts are true for all Comparable types or, as you'll see later, if a Comparator  is provided .

A heap has an important characteristic that must always be satisfied. This is known as the heap invariant or heap property.
https://www.programiz.com/dsa/heap-data-structure*/



/*Here you have a generic Collection interface with the basic property count which
returns the number of elements and the boolean property isEmpty which just tests if
the count is 0. It also contains the classical operations of inserting and
deletion.Given that you can define the Heap interface like this.

----------------------Key Points---------------------
* Here’s a summary of the algorithmic complexity of the heap operations you implemented in this chapter:
https://assets.alexandria.raywenderlich.com/books/dsk/images/60c605f35bc4d8eeb918e823645d47529e29ba5ca655516fbde640d3bd7d3c44/original.png

* The heap data structure is good for maintaining the highest or lowest priority element.
* Every time you insert or remove items from the heap, you must check to see if it satisfies the rules of the priority.*/
interface Collection<T> {
    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

    fun insert(element: T)

    fun remove(): T?

    fun remove(index: Int): T?
}


interface Heap<T> : Collection<T> {

    /*The peek operation is a generalization of methods returning the min or the max depending on the implementation.
     Because of this you can usually find the same operation with name extract-min or extract-max.*/
    fun peek(): T?

    fun merge(heap: AbstractHeap<T>)

    fun isMinHeap(): Boolean
}

abstract class AbstractHeap<T>() : Heap<T> {
    var elements: ArrayList<T> = ArrayList<T>()

    override val count: Int
        get() = elements.size

    override fun peek(): T? = elements.firstOrNull()

    /*Complexity: The overall complexity of insert() is O(log n). Appending an
    element in an array takes only O(1), while sifting up elements in a heap takes O(log n).*/
    override fun insert(element: T) {
        elements.add(element) // 1-insert appends the element to the array and then performs a sift up
        siftUp(count - 1) // 2-siftUp swaps the current node with its parent, as long as that node has a higher priority than its parent.
    }

    private fun siftUp(index: Int) {
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parent]) > 0) {
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)
        }
    }

    override fun remove(): T? {
        if (isEmpty) return null // 1-Check to see if the heap is empty. If it is, return null.

        Collections.swap(elements, 0, count - 1) // 2-Swap the root with the last element in the heap.
        val item = elements.removeAt(count - 1) // 3-Remove the last element (the maximum or minimum value) and return it.
        siftDown(0) // 4-The heap may not be a maxheap or minheap anymore, so you must perform a sift down to make sure it conforms to the rules.
        return item
    }

    /*siftDown() accepts, as parameter, the index of the element to consider as the parent node to swap with one of the children until it finds the right position.
    * Complexity: The overall complexity of remove() is O(log n).
    * Swapping elements in an array takes only O(1), while sifting down elements in a heap takes O(log n) time.*/
    private fun siftDown(index: Int) {
        var parent = index // 1-Store the parent index.
        while (true) { // 2-Continue sifting until you return.
            val left = leftChildIndex(parent) //3-Get the parent’s left and right child index.
            val right = rightChildIndex(parent) //and right child index.
            var candidate = parent // 4-candidate is used to keep track of which index to swap with the parent.
            if (left < count &&
                compare(elements[left], elements[candidate]) > 0
            ) {
                candidate = left //5-If there’s a left child, and it has a higher priority than its parent, make it the candidate.
            }
            if (right < count &&
                compare(elements[right], elements[candidate]) > 0
            ) {
                candidate = right // 6-If there’s a right child, and it has an even greater priority, it will become the candidate instead.
            }
            if (candidate == parent) {
                return // 7-If candidate is still parent, you have reached the end, and no more sifting is required.
            }
            Collections.swap(elements, parent, candidate) // 8-Swap candidate with parent and set it as the new parent to continue sifting.
            parent = candidate
        }
    }

    //Complexity: Removing an arbitrary element from a heap is an O(log n) operation.
    override fun remove(index: Int): T? {
        if (index >= count) return null // 1-Check to see if the index is within the bounds of the array. If not, return null.

        return if (index == count - 1) {
            elements.removeAt(count - 1) // 2-If you’re removing the last element in the heap, you don’t need to do anything special. Simply remove and return the element.
        } else {
            Collections.swap(elements, index, count - 1) // 3-If you’re not removing the last element, first swap the element with the last element.
            val item = elements.removeAt(count - 1) // 4-Then, return and remove the last element.
            siftDown(index) // 5-Finally, perform both a sift down and a sift up to adjust the heap.
            siftUp(index)
            item
        }
    }

    /* To find the index of the element that you want to delete, you must perform a search on the heap.
     * Unfortunately, heaps are not designed for fast searches.
     * With a binary search tree, you can perform a search in O(log n) time,
     * but since heaps are built using an array, and the node ordering in an array is different, you can’t even perform a binary search.
     * Complexity: To search for an element in a heap is, in the worst-case, an O(n) operation, since you may have to check every element in the array*/
    private fun index(element: T, i: Int): Int? {
        if (i >= count) {
            return null // 1-If the index is greater than or equal to the number of elements in the array, the search failed. Return null.
        }
        if (compare(element, elements[i]) > 0) {
            /* 2-Check to see if the element that you’re looking for has higher priority than the
                current element at index i. If it does, the element you’re looking for cannot
                possibly be lower in the heap.*/
            return null
        }
        if (element == elements[i]) {
            return i // 3-If the element is equal to the element at index i, return i.
        }
        val leftChildIndex = index(element, leftChildIndex(i))
        if (leftChildIndex != null) return leftChildIndex // 4-Recursively search for the element starting from the left child of i.
        val rightChildIndex = index(element, rightChildIndex(i))
        if (rightChildIndex != null) return rightChildIndex // 5-Recursively search for the element starting from the right child of i.
        return null // 6-If both searches failed, the search failed. Return null.
    }

    /*Making an existing array following the heap properties is an operation usually called heapify.
    *
    * If a non-empty array is provided, you use this as the elements for the heap. To satisfy
        the heap’s property, you loop through the array backward, starting from the first non-leaf node, and sift down all parent nodes.
        You loop through only half of the elements because there’s no point in sifting down leaf nodes, only parent nodes.*/
    protected fun heapify(values: ArrayList<T>) {
        elements = values
        if (!elements.isEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }

    private fun leftChildIndex(index: Int) = (2 * index) + 1

    private fun rightChildIndex(index: Int) = (2 * index) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2

    abstract fun compare(a: T, b: T): Int

    /*----------Challenge 3: Heap merge---------
    * Write a method that combines two heaps.
    * ----------Solution---------
    * To merge two heaps, you first combine both arrays which takes O(m), where m is the length of the heap you are merging.
    * Building the heap takes O(n). Overall the algorithm runs in O(n).*/
    override fun merge(heap: AbstractHeap<T>) {
        elements.addAll(heap.elements)
        buildHeap()
    }

    private fun buildHeap() {
        if (!elements.isEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }

    /*-------------Challenge 4: Min heap check-----------
    * Write a function to check if a given array is a minheap.
    * ------------------Solution------------------
    * To check if the given array is a minheap, you only need to go through the parent nodes of the binary heap.
    * To satisfy the minheap, every parent node must be less than or equal to its left and right child node.
    * The time complexity of this solution is O(n). This is because you still have to go through every element in the array.*/
    override fun isMinHeap(): Boolean {
        if (isEmpty) return true // 1-If the array is empty, it’s a minheap.
        (count / 2 - 1 downTo 0).forEach {
            // 2-Go through all of the parent nodes in the array in reverse order.
            val left = leftChildIndex(it) // 3-Get the left and right child index.
            val right = rightChildIndex(it)
            if (left < count &&
                compare(elements[left], elements[it]) < 0) { // 4-Check to see if the left element is less than the parent.
                return false
            }
            if (right < count
                && compare(elements[right], elements[it]) < 0) { // 5-Check to see if the right element is less than the parent.
                return false
            }
        }
        return true // 6-If every parent-child relationship satisfies the minheap property, return true.
    }
}

class ComparableHeapImpl<T : Comparable<T>> :
    AbstractHeap<T>() {

    companion object {
        fun <T : Comparable<T>> create(
            elements: ArrayList<T>
        ): Heap<T> {
            val heap = ComparableHeapImpl<T>()
            heap.heapify(elements)
            return heap
        }
    }

    override fun compare(a: T, b: T): Int = a.compareTo(b)
}

class ComparatorHeapImpl<T>(
    private val comparator: Comparator<T>
) : AbstractHeap<T>() {

    companion object {
        fun <T> create(
            elements: ArrayList<T>,
            comparator: Comparator<T>
        ): Heap<T> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }

    override fun compare(a: T, b: T): Int =
        comparator.compare(a, b)
}