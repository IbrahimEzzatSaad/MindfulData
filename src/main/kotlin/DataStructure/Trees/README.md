
# What is Trees??????
Okay... we have a lot to talk about.. first things first..

You’ll look at the most common tree types and see how they can be 
used to solve specific computational problems.
The tree structures you’ll learn about in this section include:
•  [Trees](https://www.programiz.com/dsa/trees): The tree is a data structure of profound importance. It’s used to tackle many recurring challenges in software development such as representing hierarchical relationships, managing sorted data and facilitating fast lookup operations. There are many types of trees, and they come in various shapes and sizes.

•  [Binary Trees](https://www.programiz.com/dsa/binary-tree): You looked at a basic tree where each node can have many children. A binary tree is a tree where each node has at most two children, often referred to as the left and right children. Binary trees serve as the basis for many tree structures and algorithms. 

•  [Binary Search Trees](https://www.programiz.com/dsa/binary-search-tree): A binary search tree facilitates fast lookup, addition and removal operations. Each operation has an average time complexity of O(log n), which is considerably faster than linear data structures such as arrays and linked lists.

•  [AVL Trees](https://www.programiz.com/dsa/avl-tree): In the previous chapter, you learned about the O(log n) performance characteristics of the binary search tree. However, you also learned that unbalanced trees can deteriorate the performance of the tree, all the way down to O(n). In 1962, Georgy Adelson-Velsky and Evgenii Landis came up with the first self-balancing binary search tree: the AVL Tree.

•  Tries. The trie (pronounced as “try”) is a tree that specializes in 
storing data that can be represented as a collection, such as English words. The benefits of a trie are best illustrated by looking at it in the context of prefix matching.


## Introduction to Trees
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/03e731917c96a3836d7144b50f15027052d4816e63ee0190be8e232d4ff00cfc/original.png)
The tree is a data structure of profound importance. It’s used to tackle many 
recurring challenges in software development, such as:
  

 - Representing hierarchical relationships.
 -  Managing sorted data.   
 -  Facilitating fast lookup operations.

There are many types of trees, and they come in various shapes and sizes.


### Terminology
There are many terms associated with trees, so it makes sense to get familiar with a 
few of them before starting.

**Node**
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/393ecfcdac5f9391f80989ff5067302f000602bb6edaa591cdf72ff1c656cbc1/original.png)
Like the linked list, trees are made up of nodes.
Each node encapsulates some data and keeps track of its children.


**Parent and child**
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/1cc8da97031a6fc73816a9589ddcb70f57c1d14062a25c3e6fe58f4def9780f8/original.png)
Trees are viewed starting from the top and branching toward the bottom — just like a 
real tree, only upside-down.

Every node, except for the first one, is connected to a single node above, which is 
referred to as a parent node. 

The nodes directly below and connected to the parent node are known as child nodes. In a tree, every child has exactly one parent. That’s what makes a tree, well, a tree.


**Root**
The topmost node in the tree is called the root of the tree. It’s the only node that has no parent:
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/a3b9305df9c4ca27bc701cd76a603103183bd16a59cce08dc85d14f1aa90c3f7/original.png)



**Leaf**
A node that has no children is called a leaf:
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/6264cce49aa7a360df3165dc06a3bc7dce38bb53d6b5a5069a2958cf3d26ecd3/original.png)




## Traversal algorithms

Traversing a tree means visiting every node in the tree. You might, for instance, want to add all the values in the tree or find the largest one. For all these operations, you will need to visit each node of the tree.

Linear data structures like arrays,  [stacks](https://www.programiz.com/data-structures/stack),  [queues](https://www.programiz.com/data-structures/queue), and  [linked list](https://www.programiz.com/data-structures/linked-list)  have only one way to read the data. But a hierarchical data structure like a  [tree](https://www.programiz.com/data-structures/trees)  can be traversed in different ways.

The struct node pointed to by  left  and  right  might have other left and right children so we should think of them as sub-trees instead of sub-nodes.

According to this structure, every tree is a combination of

-   A node carrying data
-   Two subtrees

![root node with left subtree and right subtree](https://cdn.programiz.com/sites/tutorial2program/files/tree_traversal_sub-tree-concept.png "Left and Right Subtree")

Left and Right Subtree

Remember that our goal is to visit each node, so we need to visit all the nodes in the subtree, visit the root node and visit all the nodes in the right subtree as well.


**Depth-ﬁrst traversal**
![enter image description here](https://miro.medium.com/max/1400/1*LUL63FWqneOfsLKqMtHKFw.gif)
Depth-first traversal starts at the root node and explores the tree as far as possible along each branch before reaching a leaf and then backtracking.

**Level-order traversal**
![enter image description here](https://miro.medium.com/max/500/1*2NIfAdSadsdK2rP015f6Xg.gif)
Level-order traversal is a technique that visits each node of the tree based on the depth of the nodes. Starting at the root, every node on a level is visited before going to a lower level.

**In-order traversal**
![enter image description here](https://miro.medium.com/max/500/1*bxQlukgMC9cGv_MFUllX2Q.gif)
In-order traversal visits the nodes of a binary tree in the following order, starting 
from the root node:
•  If the current node has a left child, recursively visit this child first.
•  Then visit the node itself.
•  If the current node has a right child, recursively visit this child.


**Pre-order traversal** 
![enter image description here](https://miro.medium.com/max/500/1*UGoV21qO6N8JED-ozsbXWw.gif)
visits the nodes of a binary tree in the following order:
•  Visits the current node first.
•  Recursively visits the left and right child.


**Post-order traversal**
![enter image description here](https://miro.medium.com/max/500/1*UGrzA4qtLCaaCiNAKZyj_w.gif)
Post-order traversal always visits the nodes of a binary tree in the following order:
•  Recursively visits the left and right child.
•  Only visits the current node after the left and right child have been visited recursively.

## Common types of trees
We have implemented five types of trees in this package.

**Tree**

The tree is a data structure of profound importance. It’s used to tackle many 
recurring challenges in software development, such as:
-  Representing hierarchical relationships.
-  Managing sorted data.
-  Facilitating fast lookup operations.

There are many types of trees, and they come in various shapes and sizes. 

**Binary Trees**

A binary tree is a tree in which each node has at most two children, often referred to as the left and right children:
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/508d22caa1902be997feacfdedc6203a311f33df3c5ebbe78314279a23d46c35/original.png)
Binary trees serve as the basis for many tree structures and algorithms. In this 
chapter, you’ll build a binary tree and learn about the three most important tree 
traversal algorithms.


**Binary Search Trees**

A binary search tree, or BST, is a data structure that facilitates fast lookup, insert 
and removal operations.

Consider the following decision tree where picking a side forfeits all of the possibilities of the other side, cutting the problem in half.
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/478e786d674f2604bf888ad7d72e543314b708191e6721ae65892d50b747924d/original.png)
Once you make a decision and choose a branch, there’s no looking back. You keep 
going until you make a final decision at a leaf node. Binary trees let you do the same 
thing. Specifically, a binary search tree imposes two rules on the binary tree:
  - The value of a left child must be less than the value of its parent.
  - Consequently, the value of a right child must be greater than or equal to the value of its parent.
  
Binary search trees use this property to save you from performing unnecessary checking. As a result, lookup, insert and removal have an average time complexity of O(log n), which is considerably faster than linear data structures such as arrays and linked lists.



**AVL Trees**

AVL tree is a self-balancing binary search tree in which each node maintains extra information called a balance factor whose value is either -1, 0 or +1.

AVL tree got its name after its inventor Georgy Adelson-Velsky and Landis.

Balance Factor:

Balance factor of a node in an AVL tree is the difference between the height of the left subtree and that of the right subtree of that node.

Balance Factor = (Height of Left Subtree - Height of Right Subtree) or (Height of Right Subtree - Height of Left Subtree)

The self balancing property of an avl tree is maintained by the balance factor. The value of balance factor should always be -1, 0 or +1.

An example of a balanced avl tree is:
![avl tree](https://cdn.programiz.com/sites/tutorial2program/files/avl-tree-final-tree-1_0_2.png "avl tree final")



**Tries**

The trie (pronounced try) is a tree that specializes in storing data that can be 
represented as a collection, such as English words:
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/afaa85b9353ee595a31b187138adf4be34f1347b7b1a3bd6d4b31b575ae28bef/original.png)

> A trie containing the words CAT, CUT, CUTE, TO, and B

Each character in a string is mapped to a node. The last node in each string is marked 
as a terminating node (a dot in the image above). The benefits of a trie are best 
illustrated by looking at it in the context of prefix matching.


## Key points
-  Trees share some similarities to linked lists. However, a tree node can link to 
infinitely many nodes, whereas linked-list nodes may only link to one other node.
-  Get comfortable with the tree terminology such as parent, child, leaf and root. 
Many of these terms are common and are used to help explain other tree 
structures.
-  Traversals, such as depth-first and level-order traversals, aren’t specific to only 
the general type of tree. They work on other types of trees as well, although their 
implementation is slightly different based on how the tree is structured.
-  Trees are a fundamental data structure with different implementations. 
- ---
- The binary tree is the foundation to some of the most important tree structures. 
The binary search tree and AVL tree are binary trees that impose restrictions on 
the insertion/deletion behaviors.
-  In-order, pre-order and post-order traversals aren’t just important only for the 
binary tree; if you’re processing data in any tree, you’ll interface with these 
traversals regularly.
---
-  The binary search tree is a powerful data structure for holding sorted data.
-  Average performance for insert, remove and contains in a BST is O(log n).
-  Performance will degrade to O(n) as the tree becomes unbalanced. 
- --
-   A self-balancing tree avoids performance degradation by performing a balancing 
procedure whenever you add or remove elements in the tree.
-  AVL trees preserve balance by readjusting parts of the tree when the tree is no 
longer balanced.
---
-  Tries provide great performance metrics in regards to prefix matching.
- Tries are relatively memory efficient since individual nodes can be shared between 
many different values. For example, “car”, “carbs”, and “care” can share the first 
three letters of the word.
## 📒 References 
[Programiz- Trees](https://www.programiz.com/dsa/trees)
[TowardsDataScience - types of traversals](https://towardsdatascience.com/4-types-of-tree-traversal-algorithms-d56328450846)
