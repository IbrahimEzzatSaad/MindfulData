package DataStructure.Stack

import LinkedList

/*--------------Stack operations--------------*/
/*Stacks are useful, and also exceedingly simple. The DataStructure.LinkedList.main goal of building a stack is to enforce how you access your data.

    There are only two essential operations for a stack:

      *  push: Adding an element to the top of the stack.
      *  pop: Removing the top element of the stack.

   This means that you can only add or remove elements from one side of the data structure.
   In computer science, a stack is known as the LIFO (last-in first-out) data structure.
   Elements that are pushed in last are the first ones to be popped out.*/
interface StackInterface<Element> {

    fun peek(): Element?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0




    fun push(element: Element)

    fun pop(): Element?
}

//Note: The previous Stack interface is different from the Stack class provided by Kotlin (or Java) which extends the Vector class and provides methods we don’t need here.




/*-----------------------------------------------------------------------------------------------------*/



/*You can implement your Stack interface in different ways and choosing the right storage type is important.
  The ArrayList is an obvious choice since it offers constant time insertions and deletions at one end via add and removeAt with the last index as a parameter.
  Usage of these two operations will facilitate the LIFO nature of stacks.*/
class Stack<T : Any>() : StackInterface<T> {
    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }


    // In the push method you just append the value passed as parameter to the end of the ArrayList using it’s add method.
    override fun push(element: T) {
        storage.add(element)
    }

    // In the pop method you simply return null if the storage is empty, or you remove and return the last element you’have inserter.
    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }




    /*----------------------------Non-essential operations----------------------------*/

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size






    /*----------------------------Less is more----------------------------*/

    /*You may have wondered if you could adopt the Kotlin collection interfaces for the stack.
      A stack’s purpose is to limit the number of ways to access your data,
      and adopting interfaces such as Iterable would go against this goal by exposing all of the elements via iterators. In this case, less is more!
      You might want to take an existing list and convert it to a stack so that the access order is guaranteed. Of course, it would be possible to loop through the array elements and push each element.
      However, you can write a static factory method that directly adds these elements to the Stack implementation.*/

    companion object {
        fun <Element : Any> create(items: Iterable<Element>): StackInterface<Element> {
            val stack = Stack<Element>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }

}

/*Here we made a step further and made our stack initializable by listing its elements, similar to listOf() and other standard library collection factory functions.*/
fun <Element : Any> stackOf(vararg elements: Element): StackInterface<Element> {
    return Stack.create(elements.asList())
}



