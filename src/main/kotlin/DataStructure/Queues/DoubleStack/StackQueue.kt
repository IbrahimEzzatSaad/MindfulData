package DataStructure.Queues.DoubleStack

import DataStructure.Queues.Queue

/**------------------Double-stack implementation-----------------**/


/*-------Strengths and weaknesses-------
  Here’s a summary of the algorithmic and storage complexity of your two-stack-based implementation
  https://assets.alexandria.raywenderlich.com/books/dsk/images/9200faa2c532ae7970ef7166f0e1e6c5e3bcb0475ffbd96e569f2d77083f0942/original.png

  Compared to the list-based implementation, by leveraging two stacks, you were able to transform dequeue() into an amortized O(1) operation.

  Moreover, your two-stack implementation is fully dynamic and doesn’t have the fixed size restriction that your ring-buffer-based queue implementation has.

  Finally, it beats the linked list in terms of spatial locality. This is because list elements are next to each other in memory blocks. So a large number of elements will be loaded in a cache on first access.

  Compare the two images on the following page; one has elements in a contiguous array, the other has elements scattered all over memory:
  Elements in a contiguous array: https://assets.alexandria.raywenderlich.com/books/dsk/images/e04a3c4918ef543bcd4a68bf31275ab234344c3c43b0e37fff799064de6ea67e/original.png
  Elements in a linked list, scattered all over memory: https://assets.alexandria.raywenderlich.com/books/dsk/images/049b9da346150db61e96bf046902c0b5aa9a6571109396a974d85997586bbd4a/original.png
  In a linked list, elements aren’t in contiguous blocks of memory. This could lead to more cache misses, which will increase access time.*/



//The idea behind using two stacks is simple. Whenever you enqueue an element, it goes in the right stack.
//When you need to dequeue an element, you reverse the right stack and place it in the left stack so that you can retrieve the elements using FIFO order.
class StackQueue<T : Any> : Queue<T> {
    private val leftStack = StackImpl<T>()
    private val rightStack = StackImpl<T>()







    // To check if the queue is empty, simply check that both the left and right stack are empty.
    // This means that there are no elements left to dequeue, and no new elements have been enqueued.
    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty



    /*As you already know, there will be a time when you need to transfer the elements from the right stack into the left stack.
      That needs to happen whenever the left stack is empty.*/
    private fun transferElements() {
        /*With this code, you pop elements from the right stack and push them into the left stack.
          You already know from the previous chapter that stacks work in a LIFO way (last in, first out).
          You’ll get them in DataStructure.LinkedList.reversed order without any additional work.*/
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }




    /* You know that peeking looks at the top element. If the left stack is not empty, the element on top of this stack is at the front of the queue.

     If the left stack is empty, you use transferElements(). That way, leftStack.peek() will always return the correct element or null.
     isEmpty() is still an O(1) operation, while peek() is O(n).

     While this peek() implementation might seem expensive, it’s amortized to O(1) because each element in the queue only has to be moved from the right stack to the left stack once.
     If you have a lot of elements in the right stack, calling peek() will be O(n) for just that one call when it has to move all of those elements.
     Any further calls will be O(1) again.*/
     override fun peek(): T? {
         if (leftStack.isEmpty) {
             transferElements()
         }
         return leftStack.peek()
     }
    /*Note: You could also make peak() operations precisely O(1) for all calls if you implemented a method in Stack that let you look at the very bottom of the right stack.
     That’s where the first item of the queue is if they’re not all in the left stack, which is what peek() should return in that case.*/






    /* Recall that the right stack is used to enqueue elements.
     * Previously, from implementing Stack, you know that pushing an element onto it is an O(1) operation.*/
    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }





    /* Dequeue
     * Removing an item from a two-stack-based implementation is as tricky as peeking.
     * Remember, you only transfer the elements in the right stack when the left stack is empty. This makes dequeue() an amortized O(1) operation, just like peek().*/
    override fun dequeue(): T? {
        if (leftStack.isEmpty) { // 1-Check to see if the left stack is empty.
            transferElements() // 2-If the left stack is empty, you need to transfer the elements from the right stack in DataStructure.LinkedList.reversed order.
        }
        return leftStack.pop() // 3-Remove the top element from the left stack.
    }




    //Here, you print the contents of the two stacks that represent your queue.
    override fun toString(): String {
        return "Left stack: \n$leftStack \n Right stack: \n$rightStack"
    }

    override val count: Int
        get() = leftStack.count + rightStack.count


}