package DataStructure.Trees.AVL

typealias Visitor<T> = (T) -> Unit

class AVLNode<T : Comparable<T>>(value: T) : TraversableBinaryNode<AVLNode<T>, T>(value) {

    val min: AVLNode<T>?
        get() = leftChild?.min ?: this

    /*To keep a binary tree balanced, you need a way to measure the balance of the tree.
        The AVL tree achieves this with a height property in each node.
        In tree-speak, the height of a node is the longest distance from the current node to a leaf node:
        https://assets.alexandria.raywenderlich.com/books/dsk/images/287b29d061fc27a7bde786bfbd558072e36f92da73dd0a323b5ec27d92e6e9ab/original.png
        You’ll use the relative heights of a node’s children to determine whether a particular node is balanced.

        The height of the left and right children of each node must differ at most by 1.
        This is known as the balance factor.*/
    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1

    /*The balanceFactor computes the height difference of the left and right child. If a
      particular child is null, its height is considered to be -1.
      https://www.youtube.com/watch?v=zh27Tp8HV7E*/
    val balanceFactor: Int
        get() = leftHeight - rightHeight

    override fun toString() = diagram(this)

    private fun diagram(node: AVLNode<T>?,
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

}