package DataStructure.Queues

import DataStructure.Queues.ArrayListQueue.ArrayListQueue
import DataStructure.Queues.DoubleStack.StackImpl
import DataStructure.Queues.DoubleStack.StackQueue
import DataStructure.Queues.DoublyLinkedList.LinkedListQueue
import DataStructure.Queues.Ringbuffer.RingBufferQueue

/*We’re all familiar with waiting in line. Whether you’re in line to buy tickets to your favorite movie or waiting for a printer to print a file,
  these real-life scenarios mimic the queue data structure.
  Queues use FIFO or first in, first out ordering, meaning the first element that was added will always be the first one removed.
  Queues are handy when you need to maintain the order of your elements to process later.*/

/*---------------------Key Points---------------------
* Queue takes a FIFO strategy, an element added first must also be removed first.
* Enqueue inserts an element to the back of the queue.
* Dequeue removes the element at the front of the queue.
* Elements in an array are laid out in contiguous memory blocks, whereas elements in a linked list are more scattered with potential for cache misses.
* A ring buffer based queue implementation is useful for queues with a fixed size.
* Compared to other data structures, leveraging two stacks improves the dequeue() time complexity to an amortized O(1) operation.
* The double-stack implementation beats linked list in terms of spatial locality.*/

fun main(){


    /*----First queue try----
    * This code puts Ray, Brian and Eric in the queue. It then removes Ray and peeks at Brian, but it doesn’t remove him.
    val queue = ArrayListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")*/







    /*----LinkedListQueue----
        val queue = LinkedListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
            enqueue("John")

        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")

        queue.enqueue("David")

        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")*/




    /*----Queue with Ring Buffer----
        val queue = RingBufferQueue<String>(10).apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")*/







    /*----Queue with Double Stack----
    * Similar to the previous examples, this code enqueues Ray, Brian and Eric, dequeues Ray and then peeks at Brian.
    * Note how Eric and Brian ended up in the left stack and in reverse order as the result of the dequeue operation.
        val queue = StackQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
    println("Next up: ${queue.peek()}")*/





    /*------------Challenge 3 - Monopoly
    The time complexity depends on the queue implementation you select. For the
    array-based queue, it’s overall _O(n) time complexity. dequeue takes _O(n) time
    because it has to shift the elements to the left every time you remove the first
    element.
        val queue = ArrayListQueue<String>().apply {
            enqueue("Vincent")
            enqueue("Remel")
            enqueue("Lukiih")
            enqueue("Allison")
        }
        println(queue)
        println("===== boardgame =======")
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)*/



    /*------------Challenge 4 - Reverse data------------
    val queue = ArrayListQueue<String>().apply {
        enqueue("1")
        enqueue("21")
        enqueue("18")
        enqueue("42")
    }
    println("before: $queue")
    queue.reverse()
    println("after: $queue")*/


}



    /*------------Challenge 3 - Monopoly------------
    Imagine you’re playing a game of Monopoly with your friends. The problem is that
    everyone always forgets whose turn it is! Create a Monopoly organizer that tells you
    whose turn it is
    ---------------------
    *  Creating a board game manager is straightforward.
    *  Your primary concern is whose turn it is.
    *  A queue data structure is a perfect choice to take care of game turns.*/
    fun <T> Queue<T>.nextPlayer(): T? {
    // 1-Get the next player by calling dequeue. If the queue is empty, return null, as the game has probably ended anyway.
       val person = this.dequeue() ?: return null
    // 2-enqueue the same person, this puts the player at the end of the queue.
       this.enqueue(person)
    // 3-Return the next player.
       return person
    }


    /*------------Challenge 4 - Reverse data------------
     * Implement a method to reverse the contents of a queue using an extension function.
     * A queue uses first in, first out whereas a stack uses last in, first out. You can use a stack to help reverse the contents of a queue.
     * By inserting all of the contents of the queue into a stack, you basically reverse the order once you pop every element off the stack.
     */
    fun <T : Any> Queue<T>.reverse() {
        // 1-Create a stack.
        val aux = StackImpl<T>()

        // 2-dequeue all of the elements in the queue onto the stack.
        var next = this.dequeue()
        while (next != null) {
            aux.push(next)
            next = this.dequeue()
        }

        // 3-pop all of the elements off the stack and insert them into the queue.
        next = aux.pop()
        while (next != null) {
            this.enqueue(next)
            next = aux.pop()
        }
    }
