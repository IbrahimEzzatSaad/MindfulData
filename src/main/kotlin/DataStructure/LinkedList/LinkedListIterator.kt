//Again, MutableIterator is a broader interface than Iterator, so you can remove Iterator from the list of implemented interfaces.
class LinkedListIterator<T>(private val list: LinkedList<T>) : Iterator<T>, MutableIterator<T> {


    private var index = 0
    private var lastNode: Node<T>? = null

    override fun next(): T {

        // 1- You check that there are still elements to return. If there aren’t, you throw an
        //exception. This should never be the case if clients use the Iterator correctly,
        //always checking with hasNext() before trying to read a value from it with next().
        if(index >= list.size) throw IndexOutOfBoundsException()

        // 2-If this is the first iteration, there is no lastNode set, so you take the first node of the list.
        // After the first iteration, you can get the next property of the last node to
        // find the next one.
        lastNode =  if(index == 0){
            list.nodeAt(0)
        }else{
            lastNode?.next
        }

        // 3-Since the lastNode property was updated, you need to update the index too.
        //You’ve now gone through one more iteration, so the index increments
        index++
        return  lastNode!!.value
    }

    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun remove() {

        // 1- The simplest case is when you’re at the beginning of the list. Using pop() will do the trick.
        if (index == 1) {
            list.pop()
        } else {
            // 2- If the iterator is somewhere inside the list, it needs to find the previous node. That’s the only way to remove items from a linked list.
            val prevNode = list.nodeAt(index - 2) ?: return
            // 3- The iterator needs to step back so that next() returns the correct method the next time. This means reassigning the lastNode and decreasing the index.
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--

    }


}