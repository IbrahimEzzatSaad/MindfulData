package DataStructure.Queues



//This will be your starting point. From now on, everything you implement will obey the contract of this interface, which describes the core operations for a queue.
interface Queue<T> {

    //enqueue: Inserts an element at the back of the queue and returns true if the operation is successful.
    fun enqueue(element: T): Boolean

    //dequeue: Removes the element at the front of the queue and returns it.
    fun dequeue(): T?

    val count: Int
        get

    //isEmpty: Checks if the queue is empty using the count property
    val isEmpty: Boolean
        get() = count == 0

    //peek: Returns the element at the front of the queue without removing it.
    fun peek(): T?
}

//Notice that the queue only cares about removal from the front and insertion at the back.
//You don’t need to know what the contents are in between. If you did, you’d presumably use an array instead of a Queue.