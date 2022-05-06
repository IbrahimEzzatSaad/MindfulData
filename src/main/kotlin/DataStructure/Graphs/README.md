
# What is Grahps???
![enter image description here](https://media.makeameme.org/created/data-structure-data.jpg)\
A graph data structure is a collection of nodes that have data and are connected to other nodes.

Let's try to understand this through an example. On facebook, everything is a node. That includes User, Photo, Album, Event, Group, Page, Comment, Story, Video, Link, Note...anything that has data is a node.

Every relationship is an edge from one node to another. Whether you post a photo, join a group, like a page, etc., a new edge is created for that relationship.

![graph data structure explained using facebook's example. Users, groups, pages, events, etc. are represented as nodes and their relationships - friend, joining a group, liking a page are represented as links between nodes](https://cdn.programiz.com/sites/tutorial2program/files/facebook-graph.png "Example of graph data structure")

Example of graph data structure

All of facebook is then a collection of these nodes and edges. This is because facebook uses a graph data structure to store its data.

More precisely, a graph is a data structure (V, E) that consists of

-   A collection of vertices V
-   A collection of edges E, represented as ordered pairs of vertices (u,v)

You should read more about the graphs to fully understand the code and the rest of this file so I suggest reading from [here](https://www.programiz.com/dsa/graph) Just read the whole section of the Graphs or you can read it from the book I mentioned before
## ⏲ Time Complexity
This chart summarizes the cost of different operations for graphs represented by adjacency lists versus adjacency matrices.
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/208c7220466ea6d6dfaa531311cc371949c2f7849e0050652a88404847cf7dd7/original.png)

V represents vertices, and E represents edges.
An adjacency list takes less storage space than an adjacency matrix. An adjacency list simply stores the number of vertices and edges needed. 

As for an adjacency matrix, recall that the number of rows and columns is equal to the number of vertices. 
This explains the quadratic space complexity of O(V²).

Adding a vertex is efficient in an adjacency list: Simply create a vertex and set its key-value pair in the map.

It’s amortized as O(1). When adding a vertex to an adjacency matrix, you’re required to add a column to every row and create a new row for the new vertex. This is at least O(V), and if you choose to represent your matrix with a contiguous block of memory, it can be O(V²).

Adding an edge is efficient in both data structures, as they are both constant time. 

The adjacency list appends to the array of outgoing edges. The adjacency matrix sets the value in the two-dimensional array. Adjacency list loses out when trying to find a particular edge or weight. 

To find an edge in an adjacency list, you must obtain the list of outgoing edges and loop through every edge to find a matching destination. This happens in O(V) time. With an adjacency matrix, finding an edge or weight is a constant time access to retrieve the value from the two-dimensional array.

Which data structure should you choose to construct your graph?
If there are few edges in your graph, it’s considered a sparse graph, and an adjacency list would be a good fit. An adjacency matrix would be a bad choice for a sparse graph, because a lot of memory will be wasted since there aren’t many edges.

If your graph has lots of edges, it’s considered a dense graph, and an adjacency matrix would be a better fit as you’d be able to access your weights and edges far more quickly.
-  Adjacency matrix uses a square matrix to represent a graph.
-  Adjacency list is generally good for sparse graphs, when your graph has the least amount of edges.
-  Adjacency matrix is generally suitable for dense graphs, when your graph has lots of edges.
## Key points
- You can represent real-world relationships through vertices and edges.
- Think of vertices as objects and edges as the relationship between the objects.
- Weighted graphs associate a weight with every edge.
- Directed graphs have edges that traverse in one direction.
- Undirected graphs have edges that point both ways.
- Adjacency list stores a list of outgoing edges for every vertex.
## 📒 References 
[Programiz - graph](https://www.programiz.com/dsa/graph)\
[RayWenderLich - Graphs](https://www.raywenderlich.com/books/data-structures-algorithms-in-kotlin/v1.0/chapters/19-graphs#toc-chapter-022-anchor-009)
