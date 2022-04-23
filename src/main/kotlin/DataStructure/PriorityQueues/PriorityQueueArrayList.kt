package DataStructure.PriorityQueues

import java.util.*
import kotlin.Comparator


/*----------Challenge 1: Construc6ng ArrayList priority queues-----------
* To make an array-based priority queue, you need to implement the Queue interface. Instead of using a heap, you can use an array list.*/

//1-Define the AbstractPriorityQueueArrayList<T> abstract class implementing the Queue<T> interface.
abstract class AbstractPriorityQueueArrayList<T: Any> : Queue<T> {

    //2-Define the elements property of type ArrayList<T> as protected so it can be accessed by the classes extending this.
    protected val elements = ArrayList<T>()

    //3-The sort abstract function is the one you’re going to implement in different ways depending on the usage of Comparable<T> objects or a Comparator<T>.
    abstract fun sort()


    override val count: Int
        get() = elements.size

    /*The overall time complexity here is the complexity of the sort implementation, because the add operation of the ArrayList is O(1).*/
    override fun enqueue(element: T): Boolean {
        //1-Appends the element in the ArrayList.
        elements.add(element)
        //2-Sorts the elements into the ArrayList using the sort function.
        sort()
        //3-Returns true because the element was inserted with success.
        return true
    }

    /*Here, you’re assuming that the ArrayList<T> is always sorted, and if it’s not empty,
        it always contains the element with the highest priority in position 0.

        It’s important to know how the dequeue operation is O(n) because the removal of an
        item in position 0 requires the shift of all of the other elements.

        A possible optimization, which you can try as exercise, is to put the element with the highest
        priority in the last position so that you don’t have to shift any elements but instead reduce the size by 1.*/
    override fun dequeue() =
        if (isEmpty) null else elements.removeAt(0)

    override fun peek() = elements.firstOrNull()

    override fun toString() = elements.toString()
}


/*Here, you implement sort() using the same method of the Collections class. The
complexity, in this case, is O(n log n); it’s the same if you want to use a Comparator<T>*/
class ComparablePriorityQueueArrayList<T : Comparable<T>> : AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        Collections.sort(elements)
    }
}

class ComparatorPriorityQueueArrayList<T: Any>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        Collections.sort(elements, comparator)
    }
}


/* If you always insert the new item in the right position, you have to shift all of the other elements —
and this can be done in O(n). You can now write this implementation for Comparable<T> objects

This is an O(n) operation since you have to shift the existing elements to the left by
one until you find the right position.*/
class CustomPriorityQueueArrayList<T : Comparable<T>> : AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        var index = count - 2
        while (index >= 0 &&
            elements[index + 1].compareTo(elements[index]) > 0) {
            swap(index, index + 1)
            index--;
        }
    }

    private fun swap(i: Int, j: Int) {
        val tmp = elements[i]
        elements[i] = elements[j]
        elements[j] = tmp
    }
}