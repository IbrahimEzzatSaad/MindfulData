package DataStructure.Trees.BasicTree

import list.ArrayListQueue
import queue.Queue

/* * The tree is a data structure of profound importance. It’s used to tackle many recurring challenges in software development, such as:
   * Representing hierarchical relationships.
   * Managing sorted data.
   * Facilitating fast lookup operations.
   * Node: Like the linked list, trees are made up of nodes. Each node encapsulates some data and keeps track of its children.
   * Root: The topmost node in the tree is called the root of the tree.
   * Leaf: A node that has no children is called a leaf
   *
   * Parent and child: Trees are viewed starting from the top and branching toward the bottom — just like a real tree, only upside-down.
   * Every node, except for the first one, is connected to a single node above, which is
   * referred to as a parent node. The nodes directly below and connected to the parent
   * node are known as child nodes. In a tree, every child has exactly one parent. That’s what makes a tree, well, a tree.*/
class TreeNode<T>(val value: T) {
    //Each node is responsible for a value and holds references to all of its children using a mutable list.
    private val children: MutableList<TreeNode<T>> = mutableListOf()


    //This method adds a child node to a node.
    fun add(child: TreeNode<T>) = children.add(child)



    /*Depth-first traversal starts at the root node and explores the tree as far as possible
      along each branch before reaching a leaf and then backtracking.

      * This simple code uses recursion to process the next node.
        You could use your own stack if you didn’t want your implementation to be
        recursive. However, the recursive solution is more simple and elegant to code.*/
    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }





    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        forEachLevelOrder {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }


   /*-------------Challenge 1: Tree challenge-------------
     * Print the values in a tree in an order based on their level. Nodes belonging to the
       same level should be printed on the same line. For example, consider the following tree:
       * https://assets.alexandria.raywenderlich.com/books/dsk/images/0495ccf8343404f90dabea6b2faab369d5203d0387972541b3f5288ee345753d/original.png
       * Your algorithm should output the following in the console:
       * 15
       * 1 17 20
       * 1 5 0 2 5 7
       * --------------------------------------------------
       * Solution: A straightforward way to print the nodes in level-order is to leverage the level-order traversal using a Queue data structure.
       * The tricky bit is determining when a newline should occur.
       * This algorithm has a time complexity of O(n).
       * Since you initialize the Queue data structure as an intermediary container, this algorithm also uses O(n) space.*/
    fun printEachLevel() {
        /* 1-You begin by initializing a Queue data structure to facilitate the level-order traversal.
         * You also create nodesLeftInCurrentLevel to keep track of the
         * number of nodes you’ll need to work on before you print a new line.*/
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        // 2-Your level-order traversal continues until your queue is empty.
        while (queue.isEmpty.not()) {
            // 3-Inside the first while loop, you begin by setting nodesLeftInCurrentLevel to the current elements in the queue.
            nodesLeftInCurrentLevel = queue.count

            /* 4-Using another while loop, you dequeue the first nodesLeftInCurrentLevel
             * number of elements from the queue. Every element you dequeue is printed
             * without establishing a new line. You also enqueue all the children of the node.*/
            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }

            /* 5-At this point, you generate the new line using println(). In the next iteration,
             * nodesLeftInCurrentLevel is updated with the count of the queue, representing the number of children from the previous iteration.*/
            println()
        }
    }


    /*Level-order traversal is a technique that visits each node of the tree based on the
      depth of the nodes. Starting at the root, every node on a level is visited before going
      to a lower level.
      https://assets.alexandria.raywenderlich.com/books/dsk/images/52b169d59b494d46a47039f89ca552ff78d86aff88bc7937deffdb322365bc39/original.png

      Note how you use a queue to ensure that nodes are visited in the right level-order.
      You start visiting the current node and putting all its children into the queue. Then
      you start consuming the queue until it's empty. Every time you visit a node, you also
      put all it's children into the queue. This ensure that all node at the same level are
      visited one after the other.*/
    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

}


//There are multiple strategies for different trees and different problems. In all of
//these ways you can visit the node and use the information into them.
typealias Visitor<T> = (TreeNode<T>) -> Unit