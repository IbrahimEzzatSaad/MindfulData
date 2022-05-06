
# What is Breadth First Search???
![MEME!](https://memegenerator.net/img/instances/18829555.jpg)\
Traversal means visiting all the nodes of a graph. Breadth First Traversal or Breadth First Search is a recursive algorithm for searching all the vertices of a graph or tree data structure.


### BFS algorithm

A standard BFS implementation puts each vertex of the graph into one of two categories:

1.  Visited
2.  Not Visited

The purpose of the algorithm is to mark each vertex as visited while avoiding cycles.

The algorithm works as follows:

1.  Start by putting any one of the graph's vertices at the back of a queue.
2.  Take the front item of the queue and add it to the visited list.
3.  Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the back of the queue.
4.  Keep repeating steps 2 and 3 until the queue is empty.

The graph might have two different disconnected parts so to make sure that we cover every vertex, we can also run the BFS algorithm on every node

![enter image description here](https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif?20100504223639)

## ⏲ Time Complexity
When traversing a graph using BFS, each vertex is enqueued once. This has a time complexity of O(V).

During this traversal, you also visit all of the edges.

The time it takes to visit all edges is O(E). This means that the overall time complexity for breadth-first search is O(V + E).

The space complexity of BFS is O(V) since you have to store the vertices in three separate structures: queue, enqueued and visited.

## Key points
- Breadth-first search (BFS) is an algorithm for traversing or searching a graph.
- BFS explores all of the current vertex’s neighbors before traversing the next level of vertices.
- It’s generally good to use this algorithm when your graph structure has a lot of neighboring vertices or when you need to find out every possible outcome.
- The queue data structure is used to prioritize traversing a vertex’s neighboring edges before diving down a level deeper.

## 📒 References 
[Programiz - Breadth First Search](https://www.programiz.com/dsa/graph-bfs)\
[RayWenderLich - Breadth first search](https://www.raywenderlich.com/books/data-structures-algorithms-in-kotlin/v1.0/chapters/20-breadth-first-search)
