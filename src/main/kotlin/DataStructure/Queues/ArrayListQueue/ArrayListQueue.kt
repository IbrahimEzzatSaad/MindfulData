package DataStructure.Queues.ArrayListQueue

import DataStructure.Queues.Queue


/* Here’s a summary of the algorithmic and storage complexity of the ArrayList-based queue implementation.
   Most of the operations are constant time except for dequeue(), which takes linear time. Storage space is also linear.
   https://assets.alexandria.raywenderlich.com/books/dsk/images/c15c2bc2e699d4edd2a0672a19138cedfbe2db27d8267796622e39a266e624a6/original.png
   There are some shortcomings to the implementation. Removing an item from the front of the queue can be inefficient, as removal causes all elements to shift up by one. This makes a difference for very large queues.
   Once the list gets full, it has to resize and may have unused space. This could increase your memory footprint over time.
   Is it possible to address these shortcomings? Let’s look at a linked list-based implementation and compare it to an ArrayListQueue.*/

class ArrayListQueue<T> : Queue<T> {


    /*After adding multiple elements, the internal array of the ArrayList will eventually be full.
      When you want to use more than the allocated space, the array must resize to make additional room.

      Resizing is an O(n) operation. Resizing requires the list to allocate new memory and copy all existing data over to the new list.
      Since this doesn’t happen very often (thanks to doubling the size each time), the complexity still works out to be an amortized O(1).*/
    private val list = arrayListOf<T>()



    /*Using the features of ArrayList, you get the following for free:

    * Get the size of the queue using the same property of the list.
    * Return the element at the front of the queue, if there is any.

      These operations are all O(1).*/

    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)



    //Adding an element to the back of the queue is easy. You simply add the element to the end of the ArrayList
    //Regardless of the size of the list, enqueueing an element is an O(1) operation. This is because the list has empty space at the back.
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }



    /*Removing an item from the front requires a bit more work.
    * If the queue is empty, dequeue() simply returns null. If not, it removes the element from the front of the list and returns it.
    * Removing an element from the front of the queue is an O(n) operation. To dequeue, you remove the element from the beginning of the list.
    * This is always a linear time operation because it requires all of the remaining elements in the list to be shifted in memory.*/
    override fun dequeue(): T? =
        if (isEmpty) null else list.removeAt(0)




    //For debugging purposes, you’ll have your queue override toString().
    override fun toString(): String = list.toString()



}