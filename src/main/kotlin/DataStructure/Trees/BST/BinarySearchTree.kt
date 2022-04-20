package DataStructure.Trees.BST

/*  A binary search tree, or BST, is a data structure that facilitates fast lookup, insert
    and removal operations. Consider the following decision tree where picking a side
    forfeits all of the possibilities of the other side, cutting the problem in half

    https://assets.alexandria.raywenderlich.com/books/dsk/images/478e786d674f2604bf888ad7d72e543314b708191e6721ae65892d50b747924d/original.png

    Once you make a decision and choose a branch, there’s no looking back. You keep
    going until you make a final decision at a leaf node. Binary trees let you do the same
    thing. Specifically, a binary search tree imposes two rules on the binary tree you saw in the previous tree:

    *  The value of a left child must be less than the value of its parent.
    *  Consequently, the value of a right child must be greater than or equal to the value of its parent.

    Binary search trees use this property to save you from performing unnecessary checking.
    As a result, lookup, insert and removal have an average time complexity of O(log n),
    which is considerably faster than linear data structures such as arrays and linked lists.

    In this chapter, you’ll learn about the benefits of the BST relative to an array and
    implement the data structure from scratch.

    binary search trees can only hold values that are Comparable.

    -----------------------------Key Points--------------------------
    * The binary search tree is a powerful data structure for holding sorted data.
    * Average performance for insert, remove and contains in a BST is O(log n).
    * Performance will degrade to O(n) as the tree becomes unbalanced.
    This is undesirable, so you’ll learn about a self-balancing binary search tree known as the
    AVL tree in the next chapter.*/
class BinarySearchTree<T : Comparable<T>> {

    var root: BinaryNode<T>? = null

    /*Following the rules of the BST, nodes of the left child must contain values less than
      the current node, whereas nodes of the right child must contain values greater than
      or equal to the current node. You’ll implement insert while respecting these rules.*/
    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(
        node: BinaryNode<T>?,
        value: T
    ): BinaryNode<T> {
        /* 1-This is a recursive method, so it requires a base case for terminating recursion.
         If the current node is null, you’ve found the insertion point and return the new BinaryNode.*/
        node ?: return BinaryNode(value)

        /* 2-This if statement controls which way the next insert call should traverse. If the
            new value is less than the current value, you call insert on the left child. If the
            new value is greater than or equal to the current value, you call insert on the
            right child.*/
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }

        /* 3-Return the current node. This makes assignments of the form node =
            insert(node, value) possible as insert will either create node (if it was null)
            or return node (if it was not null).*/
        return node
    }




    /*Removing elements is a little more tricky, as there are a few different scenarios you
      need to handle:

      * Removing a leaf node is straightforward; simply detach the leaf node.
      * When removing nodes with one child, you need to reconnect that one child with the rest of the tree.
      * For deleting a node with two children its bit more complicated.
      in order to understand the next function please read this article.
      https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/ */
    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
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
                   You replace the node’s value with the smallest value from the right subtree. You
                   then call remove on the right child to remove this swapped value.*/
                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }

    override fun toString() = root?.toString() ?: "empty tree"


    /*Finding an element in a BST requires you to traverse through its nodes.
     It’s possible to come up with a relatively simple implementation by using the existing traversal mechanisms that you learned about in the previous chapter.

     In-order traversal has a time complexity of O(n), thus this implementation of
     contains has the same time complexity as an exhaustive search through an
     unsorted array. However, there is a better way!

     You can rely on the rules of the BST to avoid needless comparisons
     This implementation of contains is an O(log n) operation in a balanced binary search tree.*/
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


    /*----------Challenge 3 : BSTs with same elements?-----------
    * Create a method that checks if the current tree contains all of the elements of another tree.
    * --------------------------------
    * Your goal is to create a method that checks if the current tree contains all of the
    elements of another tree. In other words, the values in the current tree must be a
    superset of the values in the other tree.

    * The time complexity for this algorithm is O(n). The space complexity for this algorithm is O(n).*/
    fun contains(subtree: BinarySearchTree<T>): Boolean {
        // 1-Inside contains, you begin by inserting all of the elements of the current tree into a set.
        val set = mutableSetOf<T>()
        root?.traverseInOrder {
            set.add(it)
        }
        /* 2-isEqual will store the result. For every element in the subtree, you check if the
        value is contained in the set. If at any point set.contains(it) evaluates to
        false, you’ll make sure isEqual stays false even if subsequent elements
        evaluate to true by assigning isEqual && list.contains(it) to itself.*/
        var isEqual = true
        subtree.root?.traverseInOrder {
            isEqual = isEqual && set.contains(it)
        }
        return isEqual
    }

}