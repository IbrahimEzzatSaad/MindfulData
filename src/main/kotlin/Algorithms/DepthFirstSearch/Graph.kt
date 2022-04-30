package Algorithms.DepthFirstSearch

/*-----------------DepthFirstSearch-------------
* In the previous chapter, you looked at breadth-first search (BFS) in which you had to
explore every neighbor of a vertex before going to the next level. In this chapter,
you’ll look at depth-first search (DFS), another algorithm for traversing or searching a graph.
There are many applications for DFS:
•  Topological sorting.
•  Detecting a cycle.
•  Pathfinding, such as in maze puzzles.
•  Finding connected components in a sparse graph.
To perform a DFS, you start with a given source vertex and attempt to explore a
branch as far as possible until you reach the end. At this point, you’d backtrack
(move a step back) and explore the next available branch until you find what you’re
looking for or until you’ve visited all the vertices.

* --------------------Performance------------------
* DFS visits every vertex at least once. This has a time complexity of O(V).
  When traversing a graph in DFS, you have to check all neighboring vertices to find
  one that’s available to visit. The time complexity of this is O(E) because in the worst
  case, you have to visit every edge in the graph.

  Overall, the time complexity for depth-first search is O(V + E).
  The space complexity of depth-first search is O(V) because you have to store vertices
  in three separate data structures: stack, pushed and visited.
* ---------------------Key Points-------------------
  *  Depth-first search (DFS) is another algorithm to traverse or search a graph.
  *  DFS explores a branch as far as possible until it reaches the end.
  *  Leverage a stack data structure to keep track of how deep you are in the graph.
     Only pop off the stack when you reach a dead end. */


interface Graph<T: Any> {

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
    val queue = QueueStack<Vertex<T>>()
    val enqueued = ArrayList<Vertex<T>>()
    val visited = ArrayList<Vertex<T>>()
    queue.enqueue(source) // 1
    enqueued.add(source)
    while (true) {
      val vertex = queue.dequeue() ?: break // 2
      visited.add(vertex) // 3
      val neighborEdges = edges(vertex) // 4
      neighborEdges.forEach {
        if (!enqueued.contains(it.destination)) { // 5
          queue.enqueue(it.destination)
          enqueued.add(it.destination)
        }
      }
    }
    return visited
  }


  /*With this code you define depthFirstSearch(), a new method that takes in a
    starting vertex and returns a list of vertices in the order they were visited. It uses
    three data structures:
    1. Stack: Used to store your path through the graph.
    2. pushed: Remembers which vertices were already pushed so that you don’t visit the same vertex twice. It's a MutableSet to ensure fast O(1) lookup.
    3. visited: A list that stores the order in which the vertices were visited.
    In the first step you insert the vertex passed as parameter to the three data structures.
    You do this because this is the first to be visited and it's the starting point in order to navigate the neighbors.*/
  fun depthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
    val stack = StackImpl<Vertex<T>>()
    val visited = arrayListOf<Vertex<T>>()
    val pushed = mutableSetOf<Vertex<T>>()

    stack.push(source)
    pushed.add(source)
    visited.add(source)

    outer@ while (true) {
      if (stack.isEmpty) break

      /*1-You continue to check the top of the stack for a vertex until the stack is empty.
          You’ve labeled this loop outer so that you have a way to continue to the next vertex, even within nested loops.*/
      val vertex = stack.peek()!!
      val neighbors = edges(vertex) //2-You find all the neighboring edges for the current vertex.

      if (neighbors.isEmpty()) { //3-If there are no edges, you pop the vertex off the stack and continue to the next one.
        stack.pop()
        continue
      }

      for (i in 0 until neighbors.size) {
        /*4-Here, you loop through every edge connected to the current vertex and check to
            see if the neighboring vertex has been seen. If not, you push it onto the stack and add it to the visited list.*/
        val destination = neighbors[i].destination
        if (destination !in pushed) {
          stack.push(destination)
          pushed.add(destination)
          visited.add(destination)
          continue@outer //5-Now that you’ve found a neighbor to visit, you continue the outer loop and move to the newly pushed neighbor.
        }
      }
      stack.pop() //6-If the current vertex did not have any unvisited neighbors, you know that you reached a dead end and can pop it off the stack.
    }

    //Once the stack is empty, the DFS algorithm is complete. All you have to do is return
    //the visited vertices in the order you visited them.
    return visited
  }

  /*---------------Challenge 2: Depth First Search-------------
  * depth-first search in recursive implementation.
  * Overall, the time complexity for depth-first search is O(V + E).*/
  fun depthFirstSearchRecursive(start: Vertex<T>): ArrayList<Vertex<T>> {
    val visited = arrayListOf<Vertex<T>>() //1-visited keeps track of the vertices visited in order.
    val pushed = mutableSetOf<Vertex<T>>() //2-pushed keeps tracks of which vertices have been visited.

    depthFirstSearch(start, visited, pushed) //3-Perform depth-first search recursively by calling a helper function.

    return visited
  }

  //Helper function
  fun depthFirstSearch(
    source: Vertex<T>,
    visited: ArrayList<Vertex<T>>,
    pushed: MutableSet<Vertex<T>>
  ) {
    pushed.add(source) //1-Insert the source vertex into the queue, and mark it as visited.
    visited.add(source)

    val neighbors = edges(source)
    neighbors.forEach { //2-For every neighboring edge...
      if (it.destination !in pushed) {
        depthFirstSearch(it.destination, visited, pushed) //3-As long as the adjacent vertex has not been visited yet, continue to dive deeper down the branch recursively.
      }
    }
  }

  /*-------------Challenge 3: Depth First Search Challenge---------------
  * detect if a directed graph has a cycle.
  * A graph is said to have a cycle when there’s a path of edges and vertices leading back to the same source.
  * You’re essentially performing a depth-first graph traversal by recursively diving
    down one path until you find a cycle. You’re backtracking by popping off the stack to
    find another path. The time-complexity is O(V + E).*/
  fun hasCycle(source: Vertex<T>): Boolean {
    val pushed = mutableSetOf<Vertex<T>>() //1-pushed is used to keep track of all the vertices visited.
    return hasCycle(source, pushed) //2-Recursively check to see if there’s a cycle in the graph by calling a helper function.
  }

  //Helper Function
  fun hasCycle(source: Vertex<T>, pushed: MutableSet<Vertex<T>>): Boolean {
    pushed.add(source) //1-To initiate the algorithm, first, insert the source vertex.

    val neighbors = edges(source) //2-For every neighboring edge...
    neighbors.forEach {
      if (it.destination !in pushed && hasCycle(it.destination, pushed)) { //3-If the adjacent vertex has not been visited before, recursively dive deeper down a branch to check for a cycle.
        return true
      } else if (it.destination in pushed) { //4-If the adjacent vertex has been visited before, you’ve found a cycle.
        return true
      }
    }

    pushed.remove(source) //5-Remove the source vertex so that you can continue to find other paths with a potential cycle.
    return false //6-No cycle has been found.
  }

}

enum class EdgeType {
  DIRECTED,
  UNDIRECTED
}