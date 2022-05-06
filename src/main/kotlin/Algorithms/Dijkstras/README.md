
# What is Dijkstra's Algorithm???
![enter image description here](https://memegenerator.net/img/instances/66924889.jpg)\
It differs from the minimum spanning tree because the shortest distance between two vertices might not include all the vertices of the graph.

### How Dijkstra's Algorithm works

Dijkstra's Algorithm works on the basis that any subpath  `B -> D`  of the shortest path  `A -> D`  between vertices A and D is also the shortest path between vertices B and D.

![shortest subpath property is used by dijkstra's algorithm](https://cdn.programiz.com/sites/tutorial2program/files/shortest-subpath.png "Subpaths - Dijkstra's Algorithm")

Each subpath is the shortest path

Djikstra used this property in the opposite direction i.e we overestimate the distance of each vertex from the starting vertex. Then we visit each node and its neighbors to find the shortest subpath to those neighbors.

The algorithm uses a greedy approach in the sense that we find the next best solution hoping that the end result is the best solution for the whole problem.

### Example of Dijkstra's algorithm

It is easier to start with an example and then think about the algorithm.

![Start with a weighted graph](https://cdn.programiz.com/sites/tutorial2program/files/dj-1.png "Dijkstra's algorithm steps")

Start with a weighted graph

![Choose a starting vertex and assign infinity path values to all other devices](https://cdn.programiz.com/sites/tutorial2program/files/dj-2.png "Dijkstra's algorithm steps")

Choose a starting vertex and assign infinity path values to all other devices

![Go to each vertex and update its path length](https://cdn.programiz.com/sites/tutorial2program/files/dj-3.png "Dijkstra's algorithm steps")

Go to each vertex and update its path length

![If the path length of the adjacent vertex is lesser than new path length, don't update it](https://cdn.programiz.com/sites/tutorial2program/files/dj-4.png "Dijkstra's algorithm steps")

If the path length of the adjacent vertex is lesser than new path length, don't update it

![Avoid updating path lengths of already visited vertices](https://cdn.programiz.com/sites/tutorial2program/files/dj-5.png "Dijkstra's algorithm steps")

Avoid updating path lengths of already visited vertices

![After each iteration, we pick the unvisited vertex with the least path length. So we choose 5 before 7](https://cdn.programiz.com/sites/tutorial2program/files/dj-6.png "Dijkstra's algorithm steps")

After each iteration, we pick the unvisited vertex with the least path length. So we choose 5 before 7

![Notice how the rightmost vertex has its path length updated twice](https://cdn.programiz.com/sites/tutorial2program/files/dj-7.png "Dijkstra's algorithm steps")

Notice how the rightmost vertex has its path length updated twice

![Repeat until all the vertices have been visited](https://cdn.programiz.com/sites/tutorial2program/files/dj-8.png "Dijkstra's algorithm steps")

Repeat until all the vertices have been visited

![Dijkstra](https://blog.finxter.com/wp-content/uploads/2021/12/Python-blog-Dijkstras-Algorithm.gif)

## ⏲ Time Complexity
In Dijkstra’s algorithm, you constructed your graph using an adjacency list. You used a min-priority queue to store vertices and extract the vertex with the minimum path. 

This has an overall performance of O(log V). This's because the heap operations of extracting the minimum element or inserting an element both take O(log V).

If you recall from the breadth-first search chapter, it takes O(V + E) to traverse all the vertices and edges. Dijkstra’s algorithm is somewhat similar to breadth-first search, because you have to explore all neighboring edges.

This time, instead of going down to the next level, you use a min-priority queue to select a single vertex with the shortest distance to traverse down. That means it is O(1 + E) or simply O(E). 

So, combining the traversal with operations on the min-priority queue, it takes O(E log V) to perform Dijkstra’s algorithm.
## Key points
- Dijkstra's algorithm finds a path to the rest of the nodes given a starting vertex.
- This algorithm is useful for finding the shortest paths between different endpoints.
- Visit state is used to track the edges back to the start vertex.
- The priority queue data structure helps to always return the vertex with the shortest path.
- Hence, it is a greedy algorithm!
## 📒 References 
[Programiz - Dijkstra](https://www.programiz.com/dsa/dijkstra-algorithm)\
[RayWenderLich - Dijkstra](https://www.raywenderlich.com/books/data-structures-algorithms-in-kotlin/v1.0/chapters/22-dijkstra-s-algorithm)
