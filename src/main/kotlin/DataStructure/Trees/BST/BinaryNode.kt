package DataStructure.Trees.BST

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T : Comparable<T>>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    //This recursive min property in BinaryNode will help you find the minimum node in a subtree.
    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this

    val isBinarySearchTree: Boolean
        get() = isBST(this, min = null, max = null)

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

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }


    /*------Challenge 1 : Is it a BST?-----
    function that checks if a binary tree is a binary search tree.

   * A binary search tree is a tree where every left child is less than or equal to its parent,
       and every right child is greater than its parent. An algorithm that verifies whether a
       tree is a binary search tree involves going through all the nodes and checking for this
       property.

       The time complexity of this solution is O(n) since you need to traverse through the
       entire tree once. There is also a O(n) space cost since you’re making n recursive calls.*/

    /* 1-isBST is responsible for recursively traversing through the tree and checking for
      the BST property. It needs to keep track of progress via a reference to a
      BinaryNode and also keep track of the min and max values to verify the BST property.*/
    private fun isBST(tree: BinaryNode<T>?, min: T?, max: T?): Boolean {
        /*2-This is the base case. If tree is null, then there are no nodes to inspect.
         A null node is a binary search tree, so you’ll return true in that case.*/
        tree ?: return true

        /*3-This is essentially a bounds check. If the current value exceeds the bounds of the
        min and max values, the current node does not respect the binary search tree rules.*/
        if (min != null && tree.value <= min) {
            return false
        } else if (max != null && tree.value > max) {
            return false
        }
        /*4-This line contains the recursive calls. When traversing through the left children,
        the current value is passed in as the max value. This is because nodes in the left
        side cannot be greater than the parent. Vice versa, when traversing to the right,
        the min value is updated to the current value. Nodes in the right side must be
        greater than the parent. If any of the recursive calls evaluate false, the false
        value will propagate to the top.*/
        return isBST(tree.leftChild, min, tree.value) && isBST(tree.rightChild, tree.value, max)
    }


    /*---------Challenge 2 : Equality between BSTs----------
    * Override equals() to check whether two binary search trees are equal.
    * Overriding equals() is relatively straightforward. For two binary trees to be equal,
    both trees must have the same elements in the same order.
    * The time complexity of this function is O(n). The space complexity of this function is O(n).

    1-equals recursively checks two nodes and their descendants for equality.*/
    override fun equals(other: Any?): Boolean {
        /*2-Here, you check the value of the left and right nodes for equality.
        You also recursively check the left children and the right children for equality.*/
        return if (other != null && other is BinaryNode<*>) {
            this.value == other.value &&
                    this.leftChild == other.leftChild &&
                    this.rightChild == other.rightChild
        } else {
            false
        }
    }

}