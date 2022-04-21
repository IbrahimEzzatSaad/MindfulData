package DataStructure.Trees

import DataStructure.Trees.AVL.AVLTree
import DataStructure.Trees.BST.BinarySearchTree
import DataStructure.Trees.BasicTree.TreeNode
import DataStructure.Trees.BinaryTrees.BinaryNode
import kotlin.math.pow


/*---------------------Key Points---------------------
 * Trees share some similarities to linked lists. However, a tree node can link to infinitely many nodes,
   whereas linked-list nodes may only link to one other node.
 * Traversals, such as depth-first and level-order traversals, aren’t specific to only the general type of tree.
   They work on other types of trees as well, although their implementation is slightly different based on how the tree is structured.
 * Trees are a fundamental data structure with different implementations.
   Some of these will be part of the next chapters.



 * -------------------------Key Points------------------------- *
 * The binary tree is the foundation to some of the most important tree structures.
    The binary search tree and AVL tree are binary trees that impose restrictions on
    the insertion/deletion behaviors.

 * In-order, pre-order and post-order traversals aren’t just important only for the
    binary tree; if you’re processing data in any tree, you’ll interface with these
    traversals regularly.*/
fun main(){

    /* Hierarchical structures are natural candidates for tree structures. That being the
     * case, you define three different nodes and organize them into a logical hierarchy.
     * This arrangement corresponds to the following structure:
     * https://assets.alexandria.raywenderlich.com/books/dsk/images/6ea47a252533c871ad677b47160170b97028c427ec8e5af6426fbd8e620b85aa/original.png
    val hot = TreeNode("Hot")
    val cold = TreeNode("Cold")
    val beverages = TreeNode("Beverages").run {
        add(hot)
        add(cold)
    }*/


    /*--------Recursive depth-first traversal test--------
    val tree = makeBeverageTree()
    tree.forEachDepthFirst { println(it.value) }*/



    /*--------forEachLevelOrder Test--------
    val tree = makeBeverageTree()
    tree.forEachLevelOrder { println(it.value) }*/




    /*--------Search Test--------
    Here, you used your level-order traversal algorithm. Since it visits all nodes, if there
      are multiple matches, the last match wins. This means that you’ll get different
      objects back depending on what traversal you use.
    val tree = makeBeverageTree()
    tree.search("ginger ale")?.let {
        println("Found node: ${it.value}")
    }
    tree.search("WKD Blue")?.let {
        println(it.value)
    } ?: println("Couldn't find WKD Blue")*/


//*-*-*-*-*-*-*-*-*-*-*-*-*-BinaryTree*-*-*-*-*-*-*-*-*-*-*-*-*


    /* BinaryTree Example
    https://assets.alexandria.raywenderlich.com/books/dsk/images/71207faaf04ff8483b333ac6b7d4f7a22eb6888b12f82ad03ecd8274902d155a/original.png
        val zero = BinaryNode(0)
        val one = BinaryNode(1)
        val five = BinaryNode(5)
        val seven = BinaryNode(7)
        val eight = BinaryNode(8)
        val nine = BinaryNode(9)

        seven.leftChild = one
        one.leftChild = zero
        one.rightChild = five
        seven.rightChild = nine
        nine.leftChild = eight

        val tree = seven*/

    /*Building a diagram
        println(tree)*/


    /*In-order traversal
        tree.traverseInOrder { println(it) }*/

    /*Pre-order traversal
    tree.traversePreOrder { println(it) }*/


    /*Post-order traversal
    tree.traversePostOrder { println(it) }*/


    /*Serialization Example
    The time complexity for this solution is now O(n) because you created a new reversed list and
    chose a recursive solution.
    println(tree)
    val array = tree.serialize()
    println(tree.deserializeOptimized(array))*/



//*-*-*-*-*-*-*-*-*-*-*-*-*-BinarySearchTree*-*-*-*-*-*-*-*-*-*-*-*-*
    /*
    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

        println(exampleTree)*/




    /*Removing example
    println("Tree before removal:")
    println(exampleTree)
    exampleTree.remove(3)
    println("Tree after removing root:")
    println(exampleTree)*/




//*-*-*-*-*-*-*-*-*-*-*-*-*-AVLTree*-*-*-*-*-*-*-*-*-*-*-*-*

    /*Take a moment to appreciate the uniform spread of the nodes.
    If the rotations weren’t applied, this would have become a long, unbalanced chain of right children.
    val tree = AVLTree<Int>()
    (0..14).forEach {
        tree.insert(it)
    }
    print(tree)*/


    /*Remove and insert operations example
    The self-balancing property guarantees that the insert and remove operations
    function at optimal performance with an O(log n) time complexity.

    val tree = AVLTree<Int>()
    tree.insert(15)
    tree.insert(10)
    tree.insert(16)
    tree.insert(18)
    print(tree)
    tree.remove(10)
    print(tree)*/


    val tree = AVLTree<Int>()
    (0..14).forEach {
        tree.insert(it)
    }
    println(tree)
    tree.root?.traverseInOrder { println(it) }

}


/*To test the recursive depth-first traversal function you wrote, it’s helpful to add more nodes to the tree.
  https://assets.alexandria.raywenderlich.com/books/dsk/images/878055a7ca45d9c2aeb97a466b103400a07754f573ef5ed3cbaa1b961de6f878/original.png*/
fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")

    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}



/*---------Challenge 1: Count the leaves-----------
    * A perfectly balanced tree is a tree where all of the leaves are at the same level, and
    that level is completely filled
    * https://assets.alexandria.raywenderlich.com/books/dsk/images/2bb0acc95ef5307fa51e818f06944d3d862aa96e13a807fffbbcb48fad57b038/original.JPG
    * Recall that a tree with only a root node has a height of zero.
    * Thus, the tree in the example above has a height of two.
    * You can extrapolate that a tree with a height of three would have eight leaf nodes.
    * Since each node has two children, the number of leaf nodes doubles as the height increases.
    * Therefore, you can calculate the number of leaf nodes using a simple equation:*/
fun leafNodes(height: Int): Int {
    return 2.0.pow(height).toInt()
}

/*---------Challenge 2: Count the nodes----------
* How many nodes are there in a perfectly balanced tree of height 3? What about a perfectly balanced tree of height h?
* If you examine the results of a sequence of height inputs, you’ll realize that the total
* O(1)*/
fun nodes(height: Int): Int {
    return 2.0.pow(height + 1).toInt() - 1
}


