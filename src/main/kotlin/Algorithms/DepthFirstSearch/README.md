
# What is DepthFirstSearch???
![enter image description here](https://www.banterly.net/content/images/2020/02/meme3.jpg)
Depth first Search or Depth first traversal is a recursive algorithm for searching all the vertices of a graph or tree data structure. Traversal means visiting all the nodes of a  [graph](https://www.programiz.com/dsa/graph).

A standard DFS implementation puts each vertex of the graph into one of two categories:

1.  Visited
2.  Not Visited

The purpose of the algorithm is to mark each vertex as visited while avoiding cycles.

The DFS algorithm works as follows:

1.  Start by putting any one of the graph's vertices on top of a stack.
2.  Take the top item of the stack and add it to the visited list.
3.  Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the top of the stack.
4.  Keep repeating steps 2 and 3 until the stack is empty.

![enter image description here](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)

## Depth First Search Example

Let's see how the Depth First Search algorithm works with an example. We use an undirected graph with 5 vertices.

![We start from vertex 0, the DFS algorithm starts by putting it in the Visited list and putting all its adjacent vertices in the stack.](https://cdn.programiz.com/sites/tutorial2program/files/graph-dfs-step-0.png "A DFS example")

Undirected graph with 5 vertices

We start from vertex 0, the DFS algorithm starts by putting it in the Visited list and putting all its adjacent vertices in the stack.

![Start by putting it in the Visited list and putting all its adjacent vertices in the stack.](https://cdn.programiz.com/sites/tutorial2program/files/graph-dfs-step-1.png "A DFS example")

Visit the element and put it in the visited list

Next, we visit the element at the top of stack i.e. 1 and go to its adjacent nodes. Since 0 has already been visited, we visit 2 instead.

![Next, we visit the element at the top of stack i.e. 1 and go to its adjacent nodes. Since 0 has already been visited, we visit 2 instead.](https://cdn.programiz.com/sites/tutorial2program/files/graph-dfs-step-2.png "A DFS example")

Visit the element at the top of stack

Vertex 2 has an unvisited adjacent vertex in 4, so we add that to the top of the stack and visit it.

![Vertex 2 has an unvisited adjacent vertex in 4, so we add that to the top of the stack and visit it.](https://cdn.programiz.com/sites/tutorial2program/files/graph-dfs-step-3.png "A DFS example")

Vertex 2 has an unvisited adjacent vertex in 4, so we add that to the top of the stack and visit it.

![Vertex 2 has an unvisited adjacent vertex in 4, so we add that to the top of the stack and visit it.](https://cdn.programiz.com/sites/tutorial2program/files/graph-dfs-step-4.png "A DFS example")

Vertex 2 has an unvisited adjacent vertex in 4, so we add that to the top of the stack and visit it.

After we visit the last element 3, it doesn't have any unvisited adjacent nodes, so we have completed the Depth First Traversal of the graph.

![After we visit the last element 3, it doesn't have any unvisited adjacent nodes, so we have completed the Depth First Traversal of the graph.](https://cdn.programiz.com/sites/tutorial2program/files/graph-dfs-step-5.png "A DFS example")

After we visit the last element 3, it doesn't have any unvisited adjacent nodes, so we have completed the Depth First Traversal of the graph.
## ⏲ Time Complexity
DFS visits every vertex at least once. This has a time complexity of O(V).

When traversing a graph in DFS, you have to check all neighboring vertices to find one that’s available to visit.

The time complexity of this is O(E) because in the worst case, you have to visit every edge in the graph.

Overall, the time complexity for depth-first search is O(V + E).

The space complexity of depth-first search is O(V) because you have to store vertices in three separate data structures: stack, pushed and visited.

## Key points
- Depth-first search (DFS) is another algorithm to traverse or search a graph.
- DFS explores a branch as far as possible until it reaches the end.
- Leverage a stack data structure to keep track of how deep you are in the graph. Only pop off the stack when you reach a dead end.
## 📒 References 
[Programiz - Graphs DFS](https://www.programiz.com/dsa/graph-dfs)\
[RayWenderLich - Depth First Search](https://www.raywenderlich.com/books/data-structures-algorithms-in-kotlin/v1.0/chapters/21-depth-first-search)
