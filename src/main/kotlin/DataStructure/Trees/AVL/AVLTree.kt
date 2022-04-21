package DataStructure.Trees.AVL

import kotlin.math.max


/*-------------AVLTree------------
*  unbalanced trees could deteriorate the performance of the tree, all the way down to O(n).
*  In 1962, Georgy Adelson-Velsky and Evgenii Landis came up with the first self-balancing binary search tree: the AVL tree.
*  In this chapter, you’ll dig deeper into how the balance of a binary search tree can impact performance and implement the AVL
   tree from scratch.

   * A balanced tree is the key to optimizing the performance of the binary search tree.
    There are three main states of balance. You’ll look at each one.

    * 1-Perfect balance: The ideal form of a binary search tree is the perfectly balanced state. In technical
    terms, this means every level of the tree is filled with nodes from top to bottom.
    https://assets.alexandria.raywenderlich.com/books/dsk/images/c49fdd9e708dbe7b1576a4643f51be77237ab90f4af44ec12efc6136e0aaa9c5/original.png

    * 2-“Good-enough” balance: Although achieving perfect balance is ideal, it’s rarely possible because it also
        depends on the specific number of nodes. A tree with 2, 4, 5 or 6 cannot be perfectly
        balanced since the last level of the tree will not be filled.
        https://assets.alexandria.raywenderlich.com/books/dsk/images/e5ff997dcbb6e66e058067121d296508769d87ab95c45244be8b76fb753f257e/original.png
        Because of this, a different definition exists. A balanced tree must have all its levels
        filled, except for the bottom one. In most cases of binary trees, this is the best you can do.

    * 3-Unbalanced: Finally, there’s the unbalanced state. Binary search trees in this state suffer from
        various levels of performance loss depending on the degree of imbalance.
        https://assets.alexandria.raywenderlich.com/books/dsk/images/b64b409cfbb1d103de80c079167bf80c3dbd430c21fe4150ce831c15709b1fc4/original.png





     ------------------------------Key Points---------------------
     * A self-balancing tree avoids performance degradation by performing a balancing
        procedure whenever you add or remove elements in the tree.
     * AVL trees preserve balance by readjusting parts of the tree when the tree is no longer balanced.*/
class AVLTree<T : Comparable<T>> {

    var root: AVLNode<T>? = null

    fun insert(value: T) {
        root = insert(root, value)
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(node: AVLNode<T>?, value: T): AVLNode<T>? {
        node ?: return null

        when {
            value == node.value -> {
                // 1-In the case in which the node is a leaf node, you simply return null, thereby removing the current node.
                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }
                // 2-If the node has no left child, you return node.rightChild to reconnect the right subtree.
                if (node.leftChild == null) {
                    return node.rightChild
                }
                // 3-If the node has no right child, you return node.leftChild to reconnect the left subtree.
                if (node.rightChild == null) {
                    return node.leftChild
                }
                /* 4-This is the case in which the node to be removed has both a left and right child.
                    You replace the node’s value with the smallest value from the right subtree.
                    You then call remove on the right child to remove this swapped value.*/
                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }

        /*Retrofitting the remove operation for self-balancing is just as easy as fixing insert.
         In AVLTree*/
        val balancedNode = balanced(node)
        balancedNode.height = max(
            balancedNode.leftHeight,
            balancedNode.rightHeight
        ) + 1
        return balancedNode
    }

    override fun toString() = root?.toString() ?: "empty tree"

    fun contains(value: T): Boolean {
        // 1-Start by setting current to the root node.
        var current = root

        // 2-While current is not null, check the current node’s value.
        while (current != null) {
            // 3-If the value is equal to what you’re trying to find, return true.
            if (current.value == value) {
                return true
            }

            // 4-Otherwise, decide whether you’re going to check the left or right child.
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }

        return false
    }


    /*-------Balance------
    The next task is to design a method that uses balanceFactor to decide whether a
    node requires balancing or not.

    balanced() inspects the balanceFactor to determine the proper course of action.
    All that’s left is to call balanced() at the proper spot.*/
    private fun balanced(node: AVLNode<T>): AVLNode<T> {
        return when (node.balanceFactor) {
            /*A balanceFactor of 2 suggests that the left child is heavier (that is, contains more nodes) than the right child.
                This means that you want to use either right or left-right rotations.*/
            2 -> {
                //You can use the sign of the balanceFactor to determine if a single or double rotation is required.
                if (node.leftChild?.balanceFactor == -1) {
                    leftRightRotate(node)
                } else {
                    rightRotate(node)
                }
            }
            /*A balanceFactor of -2 suggests that the right child is heavier than the left child.
                This means that you want to use either left or right-left rotations.*/
            -2 -> {
                if (node.rightChild?.balanceFactor == 1) {
                    rightLeftRotate(node)
                } else {
                    leftRotate(node)
                }
            }
            //The default case suggests that the particular node is balanced. There’s nothing to do here except to return the node.
            else -> node
        }
    }




    /*--------Rotations----------
    * The procedures used to balance a binary search tree are known as rotations. There
        are four rotations in total, one for each way that a tree can become unbalanced.
        These are known as left rotation, left-right rotation, right rotation and right-left rotation.*/
    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        // 1-The right child is chosen as the pivot. This node replaces the rotated node as the root of the subtree (it moves up a level).
        val pivot = node.rightChild!!
        /*2-The node to be rotated becomes the left child of the pivot (it moves down a level).
         This means that the current left child of the pivot must be moved elsewhere.
         https://assets.alexandria.raywenderlich.com/books/dsk/images/683431df56a82377cdd9ff9251ab1d9c15086d4fdfe5fe66dfecc7d35d323022/original.png
         In the generic example shown in the image above, this is node b. Because b is
         smaller than y but greater than x, it can replace y as the right child of x. So you
         update the rotated node’s rightChild to the pivot’s leftChild.*/
        node.rightChild = pivot.leftChild
        // 3-The pivot’s leftChild can now be set to the rotated node.
        pivot.leftChild = node
        // 4-You update the heights of the rotated node and the pivot.
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        // 5-Finally, you return the pivot so that it can replace the rotated node in the tree.
        return pivot
    }

    /*-------Right rotation--------
    Right rotation is the symmetrical opposite of left rotation. When a series of left
    children is causing an imbalance, it’s time for a right rotation.

    This is nearly identical to the implementation of leftRotate(), except the
    references to the left and right children have been swapped.*/
    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    /*-------Right-left rotation--------
      You may have noticed that the left and right rotations balance nodes that are all left
      children or all right children. Consider the case in which 36 is inserted into the
      original example tree.
      https://assets.alexandria.raywenderlich.com/books/dsk/images/d59ee50af391968accc6bbbddd0465481a756ff0ca38cbac23ef886cbe898399/original.png
      Doing a left rotation, in this case, won’t result in a balanced tree. The way to handle
      cases like this is to perform a right rotation on the right child before doing the left rotation.
      Here’s what the procedure looks like: https://assets.alexandria.raywenderlich.com/books/dsk/images/45a288c773bbe7834fda5d30a62d12222dc2e96fa8fe2441db907407290bf8bf/original.png*/
    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }


    /*Left-right rotation is the symmetrical opposite of the right-left rotation. Here’s an example:
    * https://assets.alexandria.raywenderlich.com/books/dsk/images/7c5f08be6a0826edccc8d9caa121bde48dc45a256ad19a41c42b5fc6d72368f3/original.png */
    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }



    /*----------Revisiting insertion--------
    * Instead of returning the node directly after inserting, you pass it into balanced().
       This ensures every node in the call stack is checked for balancing issues. You also
       update the node’s height.*/
    private fun insert(node: AVLNode<T>?, value: T): AVLNode<T> {
        node ?: return AVLNode(value)
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        val balancedNode = balanced(node)
        balancedNode.height = max(
            balancedNode.leftHeight,
            balancedNode.rightHeight
        ) + 1
        return balancedNode
    }

}