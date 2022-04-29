package Algorithms.BreadthFirstSearch

/*-----------BreadthFirstSearch---------------
you explored how you can use graphs to capture
relationships between objects. Remember that objects are vertices, and the
relationships between them are represented by edges.
Several algorithms exist to traverse or search through a graph’s vertices. One such
algorithm is the breadth-first search (BFS) algorithm.
You can use BFS to solve a wide variety of problems:
1.   Generating a minimum-spanning tree.
2.   Finding potential paths between vertices.
3.   Finding the shortest path between two vertices.

-----------------Performance------------
When traversing a graph using BFS, each vertex is enqueued once. This has a time
complexity of O(V). During this traversal, you also visit all of the edges. The time it
takes to visit all edges is O(E). This means that the overall time complexity for
breadth-first search is O(V + E).
The space complexity of BFS is O(V) since you have to store the vertices in three
separate structures: queue, enqueued and visited.

------------------Key Points----------------------
*  Breadth-first search (BFS) is an algorithm for traversing or searching a graph.
*  BFS explores all of the current vertex’s neighbors before traversing the next level of vertices.
*  It’s generally good to use this algorithm when your graph structure has a lot of
neighboring vertices or when you need to find out every possible outcome.
*  The queue data structure is used to prioritize traversing a vertex’s neighboring
edges before diving down a level deeper.*/

interface Graph<T: Any> {

  val allVertices: ArrayList<Vertex<T>>

  fun createVertex(data: T): Vertex<T>
  fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)
  fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
    addDirectedEdge(source, destination, weight)
    addDirectedEdge(destination, source, weight)
  }

  fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
    when (edge) {
      EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
      EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
    }
  }

  fun edges(source: Vertex<T>): ArrayList<Edge<T>>
  fun weight(source: Vertex<T>, destination: Vertex<T>): Double?

  fun numberOfPaths(source: Vertex<T>, destination: Vertex<T>): Int {
    val numberOfPaths = Ref(0) // 1
    val visited: ArrayList<Vertex<T>> = arrayListOf() // 2
    paths(source, destination, visited, numberOfPaths) // 3
    return numberOfPaths.value
  }

  fun paths(source: Vertex<T>, destination: Vertex<T>, visited: ArrayList<Vertex<T>>, pathCount: Ref<Int>) {
    visited.add(source) // 1
    if (source == destination) { // 2
      pathCount.value += 1
    } else {
      val neighbors = edges(source) // 3
      neighbors.forEach { edge ->
        // 4
        if (!visited.contains(edge.destination)) {
          paths(edge.destination, destination, visited, pathCount)
        }
      }
    }
    // 5
    visited.remove(source)
  }

  fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
    val queue = QueueStack<Vertex<T>>() //queue: Keeps track of the neighboring vertices to visit next.
    val enqueued = mutableSetOf<Vertex<T>>() //enqueued: Remembers which vertices have been enqueued, so you don’t enqueue the same vertex twice.
    val visited = ArrayList<Vertex<T>>() //visited: An array list that stores the order in which the vertices were explored.

    queue.enqueue(source) //1-You initiate the BFS algorithm by first enqueuing the source vertex.
    enqueued.add(source)

    while (true) {
      val vertex = queue.dequeue() ?: break //2-You continue to dequeue a vertex from the queue until the queue is empty.

      visited.add(vertex) //3-Every time you dequeue a vertex from the queue, you add it to the list of visited vertices.

      val neighborEdges = edges(vertex) //4-You then find all edges that start from the current vertex and iterate over them.
      neighborEdges.forEach {
        if (!enqueued.contains(it.destination)) { //5-For each edge, you check to see if its destination vertex has been enqueued before, and if not, you add it to the code.
          queue.enqueue(it.destination)
          enqueued.add(it.destination)
        }
      }
    }

    return visited
  }

//you learned how to implement the algorithm iteratively. Let’s look at how you would implement it recursively.
//The overall time complexity for breadth-first search is O(V + E).
  fun bfs(source: Vertex<T>): ArrayList<Vertex<T>> {
    val queue = QueueStack<Vertex<T>>() //1-queue keeps track of the neighboring vertices to visit next.
    val enqueued = mutableSetOf<Vertex<T>>() //2-enqueued remembers which vertices have been added to the queue.
    val visited = arrayListOf<Vertex<T>>() //3-visited is a list that stores the order in which the vertices were explored.

    queue.enqueue(source) //4-Initiate the algorithm by inserting the source vertex.
    enqueued.add(source)

    bfs(queue, enqueued, visited) //5-Perform bfs recursively on the graph by calling a helper function.

    return visited //6-Return the vertices visited in order.
  }

  private fun bfs(queue: QueueStack<Vertex<T>>, enqueued: MutableSet<Vertex<T>>, visited: ArrayList<Vertex<T>>) {
    //1- We start from the first node we dequeue from the queue of all verteces. Then we recursively continue to dequeue a vertex from the queue till it’s empty.
    val vertex = queue.dequeue() ?: return
    visited.add(vertex)//2-Mark the vertex as visited.

    val neighborEdges = edges(vertex) //3-For every neighboring edge from the current vertex.
    neighborEdges.forEach {
      if (!enqueued.contains(it.destination)) { //4-Check to see if the adjacent vertices have been visited before inserting into the queue.
        queue.enqueue(it.destination)
        enqueued.add(it.destination)
      }
    }

    bfs(queue, enqueued, visited) //5-Recursively perform bfs until the queue is empty.
  }

  fun isDisconnected(): Boolean {
    val firstVertex = allVertices.firstOrNull() ?: return false //1-If there are no vertices, treat the graph as connected.

    val visited = breadthFirstSearch(firstVertex) //2-Perform a breadth-first search starting from the first vertex. This will return allthe visited nodes.
    allVertices.forEach {//3-Go through every vertex in the graph and check to see if it has been visited before.
      if (!visited.contains(it)) return true
    }

    return false
  }

}

enum class EdgeType {
  DIRECTED,
  UNDIRECTED
}