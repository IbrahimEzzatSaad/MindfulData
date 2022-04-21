package DataStructure.Trees.AVL


/*--------------Challenge 3: Some refactoring---------
* Since there are many variants of binary trees, it makes sense to group shared functionality in an abstract class.

* The traversal methods are a good candidate.
  TraversableBinaryNode abstract class that provides a default implementation of the traversal methods so that concrete subclasses get these
    methods for free. Have AVLNode extend this class.*/
abstract class TraversableBinaryNode<Self : TraversableBinaryNode<Self, T>, T>(var value: T) {


    var leftChild: Self? = null
    var rightChild: Self? = null

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

}