package DataStructure.PriorityQueues

import java.util.*

/*Queues are lists that maintain the order of elements using first in, first out (FIFO)
ordering. A priority queue is another version of a queue. However, instead of using
FIFO ordering, elements are dequeued in priority order.
A priority queue can have either a:
•  Max-priority: The element at the front is always the largest.
•  Min-priority: The element at the front is always the smallest.
A priority queue is especially useful when you need to identify the maximum or
minimum value within a list of elements.



---------------------Key Points------------------
* A priority queue is often used to find the element in priority order.

* The AbstractPriorityQueue<T> implementation creates a layer of abstraction by focusing on key operations of a queue
and leaving out additional functionality provided by the heap data structure.

* This makes the priority queue’s intent clear and concise. Its only job is to enqueue and dequeue elements, nothing else.

* The AbstractPriorityQueue<T> implementation is another good example of Composition over (implementation) inheritance.*/



/*1-AbstractPriorityQueue implements the Queue interface and is generic in the type T.
    It’s an abstract class because you want to manage comparison using either
    Comparable<T> objects or an external Comparator<T> implementation.*/
abstract class AbstractPriorityQueue<T: Any> : Queue<T> {

    //2-You’re going to use a Heap<T>, so you need an abstract property that the specific implementation will define.
    abstract val heap: Heap<T>
        get

    //count uses the same property of the heap.
    override val count: Int
        get() = heap.count

    /*By calling enqueue(), you add the element into the heap using insert(), which
        guarantees to arrange data internally so that the one with the highest priority is
        ready to extract. The overall complexity of enqueue() is the same as insert(): O(log n).*/
    override fun enqueue(element: T): Boolean {
        heap.insert(element)
        return true
    }

    /*By calling dequeue(), you remove the root element from the heap using
        remove(). The Heap guarantees to get the one with the highest priority. The
        overall complexity of dequeue() is the same as remove(): O(log n) .*/
    override fun dequeue() = heap.remove()

    //peek() delegates to the same method of the heap.
    override fun peek() = heap.peek()
}

/*Here, you implement heap using a ComparableHeapImpl<T> object.
    The ComparablePriorityQueueImpl<T> needs an object that implements the Comparable<T> interface.*/
class ComparablePriorityQueueImpl<T : Comparable<T>> :
    AbstractPriorityQueue<T>() {

    override val heap = ComparableHeapImpl<T>()
}

/*Here, the only difference is the value provided to heap, which is now a
    ComparatorHeapImpl<T> and needs a Comparator<T> that you provide as a constructor parameter.*/
class ComparatorPriorityQueueImpl<T: Any>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueue<T>() {

    override val heap = ComparatorHeapImpl(comparator)
}