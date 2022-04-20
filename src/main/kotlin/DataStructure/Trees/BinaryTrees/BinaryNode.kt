package DataStructure.Trees.BinaryTrees

import kotlin.math.max

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T: Any>(var value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null




    /* Building a mental model of a data structure can be quite helpful in learning how it
       works. To that end, you’ll implement a reusable algorithm that helps visualize a
       binary tree in the console.
     * Note: This algorithm is based on an implementation by Károly Lőrentey in his
       book Optimizing Collections, available from https://www.objc.io/books/
       optimizing-collections.
     * This method recursively creates a string representing the binary tree.*/
    override fun toString() = diagram(this)

    private fun diagram(node: BinaryNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }










    /*--------Traversal-------
    * Each one of these traversal algorithms has both a time and space complexity of O(n).
      While this version of the binary tree isn’t too exciting, you can use in-
      order traversal to visit the nodes in ascending order. Binary trees can enforce this
      behavior by adhering to some rules during insertion.*/

    /*-----In-order traversal-----
        In-order traversal visits the nodes of a binary tree in the following order, starting
        from the root node:
        *  If the current node has a left child, recursively visit this child first.
        *  Then visit the node itself.
        *  If the current node has a right child, recursively visit this child.
        https://assets.alexandria.raywenderlich.com/books/dsk/images/9895d0d65e05ca89239af04101905c8f28872c656e87568af1105e12c76f3a7b/original.png

        you first traverse to the left-most node before
        visiting the value. You then traverse to the right-most node.*/
    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }




    /*Pre-order traversal
        Pre-order traversal visits the nodes of a binary tree in the following order:
        *  Visits the current node first.
        *  Recursively visits the left and right child.
        https://assets.alexandria.raywenderlich.com/books/dsk/images/a0834182882d99c3f8e928275970a4e38712e57bc3fc858243440961dfb256bb/original.png*/
    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }






    /*Post-order traversal
        Post-order traversal always visits the nodes of a binary tree in the following order:
        *  Recursively visits the left and right child.
        *  Only visits the current node after the left and right child have been visited recursively.
        https://assets.alexandria.raywenderlich.com/books/dsk/images/d03f2f6a1551973bfaf95d4a3208127d9095795ed5c2aecb35392a82bc886cd2/original.png
        In other words, given any node, you’ll visit its children before visiting itself. An
        interesting consequence of this is that the root node is always visited last.*/
    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }




    /*------------------Challenge 1: The height of the tree------------------
    * Given a binary tree, find the height of the tree. The height of the binary tree is
        determined by the distance between the root and the furthest leaf. The height of a
        binary tree with a single node is zero since the single node is both the root and the
        furthest leaf.
    --------------------------------------------------------------------------
    * You recursively call the height function. For every node you visit, you add one to the
        height of the highest child. If the node is null, you return -1.
        This algorithm has a time complexity of O(n) since you need to traverse through all
        of the nodes. This algorithm incurs a space cost of O(n) since you need to make the
        same n recursive calls to the call stack.*/
    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let { 1 + max(height(node.leftChild),
            height(node.rightChild)) } ?: -1
    }




    /*------------------Challenge 2: Serializa6on of a Binary Tree------------------
    * A common task in software development is serializing an object into another data
        type. This process is known as serialization, and it allows custom types to be used in
        systems that only support a closed set of data types.
        An example of serialization is JSON. Your task is to devise a way to serialize a binary
        tree into a list, and a way to deserialize the list back into the same binary tree.

    * There are many ways to serialize or deserialize a binary tree. Your first task when
        encountering this question is to decide on the traversal strategy.
        For this solution, you’ll explore how to solve this challenge by choosing the pre-order traversal strategy.

    * This is the pre-order traversal function. As the code suggests, pre-order traversal
        traverses each node and visit the node before traversing the children.
        It’s critical to point out that you’ll need to also visit the null nodes since it’s
        important to record those for serialization and deserialization.
        As with all traversal functions, this algorithm goes through every element of the tree
        once, so it has a time complexity of O(n).*/
    fun traversePreOrderWithNull(visit: (T?) -> Unit) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }



    /* For serialization, you traverse the tree and store the values into an array.
     * The elements of the array have type T? since you need to keep track of the null nodes.
     * serialize returns a new array containing the values of the tree in pre-order.
     * The time complexity of the serialization step is O(n).
     * Because you’re creating a new list, this also incurs an O(n) space cost.*/
    fun serialize(node: BinaryNode<T> = this): MutableList<T?> {
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNull { list.add(it) }
        return list
    }





    /*In the serialization process, you performed a pre-order traversal and assembled the
      values into an array. The deserialization process is to take each value of the array
      and reassemble it back to the tree.

      Your goal is to iterate through the array and reassemble the tree in pre-order format.

       Your deserialized tree mirrors the sample tree in the provided playground. This is the behavior you want.
        However, as mention earlier, the time complexity of this function isn’t desirable.
        Because you’re calling removeAt as many times as there are elements in the array,
        this algorithm has an O(n²) time complexity. There’s an easy way to remedy that see the next function.*/
    fun deserialize(list: MutableList<T?>): BinaryNode<T>? {
        // 1-This is the base case. If removeAt returns null, there are no more elements in the array, thus you’ll end recursion here.
        val rootValue = list.removeAt(list.size - 1) ?: return null
        /* 2-You reassemble the tree by creating a node from the current value and recursively calling deserialize to assign nodes to the left and right children.
             Notice this is very similar to the pre-order traversal, except, in this case, you’re
             building nodes rather than extracting their values.*/
        val root = BinaryNode<T>(rootValue)
        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)
        return root
    }


    /*  This is a function that first reverses the array before calling the previous
        deserialize function. In the other deserialize function, find the removeAt(0)
        call and change it to list.removeAt(list.size - 1)

        This small change has a big effect on performance. removeAt(0) is an O(n)
        operation because, after every removal, every element after the removed element
        must shift left to take up the missing space. In contrast, list.removeAt(list.size - 1) is an O(1) operation.*/
    fun deserializeOptimized(list: MutableList<T?>): BinaryNode<T>? {
        return deserialize(list.asReversed())
    }




}