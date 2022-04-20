package DataStructure.Queues.DoublyLinkedList

import DataStructure.Queues.Queue
import LinkedList

/* Doubly linked list implementation
   You should already be familiar with linked lists from Chapter 3, “Linked Lists”.
   A doubly linked list is simply a linked list in which nodes also contain a reference to the previous node.*/


/* One of the main problems with ArrayListQueue is that dequeuing an item takes linear time.
  *  With the linked list implementation, you reduced it to a constant operation, O(1).
  *  All you needed to do was update the node’s previous and next pointers.
  *  The main weakness with LinkedListQueue is not apparent from the table.
  *  Despite O(1) performance, it suffers from high overhead.
  *  Each element has to have extra storage for the forward and back reference.
  *  Moreover, every time you create a new element, it requires a relatively expensive dynamic allocation.
  *  By contrast, ArrayListQueue does bulk allocation, which is faster.
  *  https://assets.alexandria.raywenderlich.com/books/dsk/images/d509e4b840159746506a709f304c58a672a4bde827872861e1d629f85c6f8944/original.png*/
class LinkedListQueue<T : Any> : Queue<T> {

    private val list = DoublyLinkedList<T>()

    private var size = 0

    override val count: Int
        get() = size


    //Behind the scenes, the doubly linked list will update its tail node’s previous and next references to the new node.
    // You also increment the size. This is an O(1) operation.
    override fun enqueue(element: T): Boolean {
        list.append(element)
        size++
        return true
    }




    //This code checks to see if the first element of the queue exists. If it doesn’t, it returns null.
    //Otherwise, it removes and returns the element at the front of the queue. In this case it also decrement the size.
    override fun dequeue(): T? {
        val firstNode = list.first ?: return null
        size--
        return list.remove(firstNode)
    }
    /*Removing from the front of the list is also an O(1) operation. Compared to the ArrayList implementation, you didn’t have to shift elements one by one.
      https://assets.alexandria.raywenderlich.com/books/dsk/images/5ee3c7e50edd03a7effa7abd40d895e93ce5a26518809806dc4364276204eb5c/original.png
      Instead, in the diagram above, you simply update the next and previous pointers between the first two nodes of the linked list.*/



    override fun toString(): String = list.toString()

    override fun peek(): T? = list.first?.value

}