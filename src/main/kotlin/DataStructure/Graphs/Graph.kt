package DataStructure.Graphs

/*What do social networks have in common with booking cheap flights around the
world? You can represent both of these real-world models as graphs

A graph is a data structure that captures relationships between objects. It’s made up
of vertices connected by edges. In the graph below, the vertices are represented by
circles, and the edges are the lines that connect them.
https://assets.alexandria.raywenderlich.com/books/dsk/images/27df606b7fbb667d3e6d32c3c9c1b2acd5ae12166e57486bf5ecbda9a57c693a/original.png

-----------------------------Key Points----------------------------
•  You can represent real-world relationships through vertices and edges.
• Think of vertices as objects and edges as the relationship between the objects.
•  Weighted graphs associate a weight with every edge.
•  Directed graphs have edges that traverse in one direction.
•  Undirected graphs have edges that point both ways.
•  Adjacency list stores a list of outgoing edges for every vertex.*/
interface Graph<T: Any> {

  //createVertex(): Creates a vertex and adds it to the graph.
  fun createVertex(data: T): Vertex<T>

  //addDirectedEdge(): Adds a directed edge between two vertices.
  fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)

  /*addUndirectedEdge(): Adds an undirected (or bi-directional) edge between two vertices.
    Remember that an undirected graph can be viewed as a bidirectional graph. Every
    edge in an undirected graph can be traversed in both directions. This is why you’ll
    implement addUndirectedEdge() on top of addDirectedEdge(). Because this
    implementation is reusable, you’ll add it as a default implementation in Graph.*/
  fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
    addDirectedEdge(source, destination, weight)
    addDirectedEdge(destination, source, weight)
  }

  /*add(): Uses EdgeType to add either a directed or undirected edge between two vertices.
   add() is a convenient helper method that creates either a directed or undirected edge.
   This is where interfaces with default methods can become very powerful.
   Anyone that implements the Graph interface only needs to implement
   addDirectedEdge() in order to get addUndirectedEdge() and add() for free.*/
  fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
    when (edge) {
      EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
      EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
    }
  }

  //edges(): Returns a list of outgoing edges from a specific vertex.
  fun edges(source: Vertex<T>): ArrayList<Edge<T>>

  //weight(): Returns the weight of the edge between two vertices.
  fun weight(source: Vertex<T>, destination: Vertex<T>): Double?


  /*---------Challenge 1: Find the distance between 2---------
  * The goal is to write a function that finds the number of paths between two vertices
    in a graph. One solution is to perform a depth-first traversal and keep track of the visited vertices.
  * You’re doing a depth-first graph traversal. You recursively dive down one path until
    you reach the destination, and back-track by popping off the stack. The time- complexity is O(V + E).*/
  fun numberOfPaths(source: Vertex<T>, destination: Vertex<T>): Int {
    val numberOfPaths = Ref(0) // 1-   numberOfPaths keeps track of the number of paths found between the source and destination.
    val visited: ArrayList<Vertex<T>> = arrayListOf() // 2-visited is an ArrayList that keeps track of all the vertices visited.
    /*3-paths is a recursive helper function that takes in four parameters. The first two
        parameters are the source and destination vertices.
        visited tracks the vertices visited, and numberOfPaths tracks the number of paths found. These last two parameters are modified within paths.*/
    paths(source, destination, visited, numberOfPaths)
    return numberOfPaths.value
  }

  fun paths(source: Vertex<T>, destination: Vertex<T>, visited: ArrayList<Vertex<T>>, pathCount: Ref<Int>) {
    visited.add(source) // 1-Initiate the algorithm by marking the source vertex as visited.
    if (source == destination) { // 2-Check to see if the source is the destination. If it is, you have found a path, so increment the count by one.
      pathCount.value += 1
    } else {
      val neighbors = edges(source) // 3-If the destination has not be found, get all of the edges adjacent to the source vertex.
      neighbors.forEach { edge ->
        // 4-For every edge, if it has not been visited before, recursively traverse the neighboring vertices to find a path to the destination vertex.
        if (!visited.contains(edge.destination)) {
          paths(edge.destination, destination, visited, pathCount)
        }
      }
    }
    // 5-Remove the source vertex from the visited list so that you can continue to find other paths to that node.
    visited.remove(source)
  }

}

enum class EdgeType {
  DIRECTED,
  UNDIRECTED
}


