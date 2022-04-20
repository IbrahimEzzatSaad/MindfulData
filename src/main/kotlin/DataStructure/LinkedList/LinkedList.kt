//You could now remove Iterable because a Collection is an Iterable anyway.
// I will leave it there so that I  can see the progress I'm making.
class LinkedList<T>: Iterable<T>, Collection<T> , MutableIterable<T>, MutableCollection<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set


    override fun isEmpty(): Boolean{
        return size == 0
    }

    override fun toString(): String{

        return if(isEmpty()){
            "Empty list"
        } else{
            head.toString()
        }
    }


    //**Adding a value at the front of the list is known as a push operation. This is also
    //known as head-first insertion. The code for it is deliciously simple.**//
    fun push(value: T): LinkedList<T>{
        head = Node(value, next = head)

       /** In the case in which you’re pushing into an empty list, the new node is both the head
        and tail of the list. Since the list now has a new node, you increment the value of
        size.**/
        if(tail == null){
            tail = head
        }
        size++
        return this
    }





    /**This adds a value at the end of the list,
    which is known as tail-end insertion.**/
    fun append(value: T): LinkedList<T>{
        // 1-  if the list is empty, you’ll need to update both head and tail to the
        //new node. Since append on an empty list is functionally identical to push, you
        //invoke push to do the work for you.
        if(isEmpty()){
            push(value)
            return this
        }
        // 2- In all other cases, you create a new node after the current tail node. tail will
        //never be null here because you’ve already handled the case where the list is
        //empty in the if statement.
        tail?.next = Node(value)

        // 3- Since this is tail-end insertion, your new node is also the tail of the list.
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>?{
        // 1- You create a new reference to head and keep track of the current number of traversals.
        var currentNode = head
        var currentIndex = 0


        // 2- Using a while loop, you move the reference down the list until you reach the desired index.
        // Empty lists or out-of-bounds indexes will result in a null return value.
        while (currentNode != null && currentIndex < index){

            currentNode = currentNode.next
            currentIndex++
        }


        return currentNode
    }


    fun insert(value: T, afterNode: Node<T>) : Node<T>{

        // 1- In the case where this method is called with the tail node, you call the functionally equivalent append method.
        // This takes care of updating tail.
        if(tail == afterNode){
            append(value)
            return tail!!
        }



        // 2- Otherwise, you create a new node and link its next property to the next node of the list.
        val newNode = Node(value = value, next = afterNode.next)


        // 3- You reassign the next value of the specified node to link it to the new node that you just created.
        afterNode.next = newNode
        size++

        return newNode

    }



    /**pop operations
    * Removing a value at the front of the list is often referred to as pop.**/
    fun pop(): T?{
        if(!isEmpty()) size--

        val result = head?.value
        head = head?.next
        if(isEmpty()){
            tail = null
        }
        return result

        /**pop() returns the value that was removed from the list.
           This value is optional since it’s possible that the list is empty.
           By moving the head down a node, you’ve effectively removed the first node of the list. The garbage collector will remove the old node from memory once the method finishes since there will be no more references attached to it.
           If the list becomes empty, you set tail to null as well.**/
    }




    /**removeLast operations
    Removing the last node of the list is somewhat inconvenient.
    Although you have a reference to the tail node, you can’t chop it off without having a reference to the node before it.
    Thus, you need to traverse the whole list to find the node before the last.**/
    fun removeLast(): T?{
        // 1- If head is null, there’s nothing to remove, so you return null.
        val head = head ?: return null

        // 2- If the list only consists of one node, removeLast is functionally equivalent to pop.
        // Since pop will handle updating the head and tail references, you can delegate this work to the pop function.
        if (head.next == null) return pop()

        // 3- At this point, you know that you’ll be removing a node,
        // so you update the size of the list accordingly.
        size--


        // 4- You keep searching for the next node until current.next is null.
        // This signifies that current is the last node of the list.
        var prev = head
        var current = head


        var next = current.next

        while(next != null){
            prev = current
            current = next
            next = current.next
        }

        // 5- Since current is the last node, you disconnect it using the prev.next reference.
        // You also make sure to update the tail reference.
        prev.next = null
        tail = prev

        return current.value

        //removeLast() requires you to traverse down the list.
        // This makes for an O(n) operation, which is relatively expensive.
    }



    /**Remove operations
    The final remove operation is removing a node at a particular point in the list.
    This is achieved much like insert(). You’ll first find the node immediately before the node you wish to remove and then unlink it.
     **/
    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        //Special care needs to be taken if the removed node is the tail node since the tail reference will need to be updated.
        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result

        /**Similar to insert(), the time complexity of this operation is O(1),
         *  but it requires you to have a reference to a particular node beforehand.
         **/
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }


    //This method iterates through all elements of the list if needed, so it has a complexity of O(n).
    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    //The second method is similar; it just works with a collection of elements.
    //As you’d probably guess, this is an inefficient method, it’s O(n^2).
    // But if the Collection interface requires it, you need to provide it.
    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        // 1-Get an iterator that will help you iterate through the collection.
        val iterator = iterator()
        // 2-Create a loop that checks if there are any elements left, and gets the next one.
        while (iterator.hasNext()) {
            val item = iterator.next()
            // 3-Check if the current element is the one you’re looking for, and if it is, remove it.
            if (item == element) {
                iterator.remove()

                // 4-Return a boolean that signals if an element has been removed.
                return true
            }
        }
        return false
    }

    //With removeAll(), you can make use of remove()
    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        //The return value of removeAll is true if any elements were removed.
        return result
    }


    //The last method to implement is retainAll(), which should remove any elements in the list besides the ones passed in as the parameter.
    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }




}