
# What is Prims Algorithm???
![enter image description here](https://pbs.twimg.com/media/E4BU33rVgAEn1oz.jpg)\
Prim's algorithm is a  [minimum spanning tree](https://www.programiz.com/dsa/spanning-tree-and-minimum-spanning-tree#minimum-spanning)  algorithm that takes a graph as input and finds the subset of the edges of that graph which

-   form a tree that includes every vertex
-   has the minimum sum of weights among all the trees that can be formed from the graph


### How Prim's algorithm works

It falls under a class of algorithms called  [greedy algorithms](https://www.programiz.com/dsa/greedy-algorithm)  that find the local optimum in the hopes of finding a global optimum.

We start from one vertex and keep adding edges with the lowest weight until we reach our goal.

The steps for implementing Prim's algorithm are as follows:

1.  Initialize the minimum spanning tree with a vertex chosen at random.
2.  Find all the edges that connect the tree to new vertices, find the minimum and add it to the tree
3.  Keep repeating step 2 until we get a minimum spanning tree

![enter image description here](https://inotgo.com/imagesLocal/202109/25/20210925212505140x_2.gif)
### Example of Prim's algorithm

![Start with a weighted graph](https://cdn.programiz.com/sites/tutorial2program/files/pa_1.png "Prim's Algorithm Steps")

Start with a weighted graph

![Choose a vertex](https://cdn.programiz.com/sites/tutorial2program/files/pa_2.png "Prim's Algorithm Steps")

Choose a vertex

![Choose the shortest edge from this vertex and add it](https://cdn.programiz.com/sites/tutorial2program/files/pa_3.png "Prim's Algorithm Steps")

Choose the shortest edge from this vertex and add it

![Choose the nearest vertex not yet in the solution](https://cdn.programiz.com/sites/tutorial2program/files/pa_4.png "Prim's Algorithm Steps")

Choose the nearest vertex not yet in the solution

![Choose the nearest edge not yet in the solution, if there are multiple choices, choose one at random](https://cdn.programiz.com/sites/tutorial2program/files/pa_5.png "Prim's Algorithm Steps")

Choose the nearest edge not yet in the solution, if there are multiple choices, choose one at random

![Repeat until you have a spanning tree](https://cdn.programiz.com/sites/tutorial2program/files/pa_6.png "Prim's Algorithm Steps")

Repeat until you have a spanning tree
## ⏲ Time Complexity
In the algorithm above, you maintain three data structures:
1.   An adjacency list graph to build a minimum spanning tree. Adding vertices and edges to an adjacency list is O(1) .
2.   A Set to store all vertices you have visited. Adding a vertex to the set and checking if the set contains a vertex also have a time complexity of O(1).
3.   A min-priority queue to store edges as you explore more vertices. The priority queue is built on top of a heap and insertion takes O(log E).

The worst-case time complexity of Prim’s algorithm is O(E log E). This is because, each time you dequeue the smallest edge from the priority queue, you have to traverse all the edges of the destination vertex ( O(E) ) and insert the edge into the priority queue ( O(logE) ).

## Key points
- You can leverage three different data structures: Priority queue, set, and adjacency lists to construct Prim's algorithm.
- Prim's algorithm is a greedy algorithm that constructs a minimum spanning tree.
- A spanning tree is a subgraph of an undirected graph that contains all the vertices with the fewest number of edges.

## 📒 References 
[Programiz - Prim Algorithms](https://www.programiz.com/dsa/prim-algorithm)\
[Raywenderlich - Prims Algorithms](https://www.raywenderlich.com/books/data-structures-algorithms-in-kotlin/v1.0/chapters/23-prim-s-algorithm)
