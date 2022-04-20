package DataStructure.Queues.Ringbuffer

import DataStructure.Queues.Queue


 /* A ring buffer, also known as a circular buffer, is a fixed-size array.
  * This data structure strategically wraps around to the beginning when there are no more items to remove at the end.
  * You’ll notice a RingBuffer class inside this package, which you can look at to understand its internal mechanics.*/

 /* How does the ring-buffer implementation compare? Let’s look at a summary of the algorithmic and storage complexity.
   https://assets.alexandria.raywenderlich.com/books/dsk/images/a2f9ece55f108c9585d2a748dde0a89a5a8e318215a16378e0f29d5f46f56a02/original.png
  * The ring-buffer-based queue has the same time complexity for enqueue and dequeue as the linked-list implementation.
  * The only difference is the space complexity. The ring buffer has a fixed size, which means that enqueue can fail.*/


 /* Here, you define a generic RingBufferQueue. Note that you must include a size parameter since the ring buffer has a fixed size.
  * To implement the Queue interface, you also need to implement peek() and the count property using the same from the RingBuffer class.
  * Once you provide the count property, the isEmpty property is already defined in the Queue interface.
  * Instead of exposing ringBuffer, you provide these helpers to access the front of the queue and to check if the queue is empty. Both of these are O(1) operations.*/
class RingBufferQueue<T>(size: Int) : Queue<T> {

    private val ringBuffer: RingBuffer<T> = RingBuffer(size)

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? = ringBuffer.first



     /* To append an element to the queue, you call write() on the ringBuffer. This increments the write pointer by one.
      * Since the queue has a fixed size, you must now return true or false to indicate whether the element has been successfully added.
      * enqueue() is still an O(1) operation.*/
     override fun enqueue(element: T): Boolean =
         ringBuffer.write(element)



     /* To remove an item from the front of the queue.
      * This code checks if the queue is empty and, if so, returns null.
      * If not, it returns an item from the front of the buffer.
      * Behind the scenes, the ring buffer increments the read pointer by one.*/
     override fun dequeue(): T? =
         if (isEmpty) null else ringBuffer.read()




     /*This code creates a string representation of the queue by delegating to the underlying ring buffer.*/
     override fun toString(): String = ringBuffer.toString()

 }