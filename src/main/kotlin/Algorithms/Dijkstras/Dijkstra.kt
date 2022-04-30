package Algorithms.Dijkstras

/*Have you ever used the Google or Apple Maps app to find the shortest distance or
  fastest time from one place to another? Dijkstra’s algorithm is particularly useful
  in GPS networks to help find the shortest path between two places.
  Dijkstra’s algorithm is a greedy algorithm. A greedy algorithm constructs a solution
  step-by-step, and it picks the most optimal path at every step.

  In particular, Dijkstra’s algorithm finds the shortest paths between vertices in either directed or
  undirected graphs. Given a vertex in a graph, the algorithm will find all shortest paths from the starting vertex.
  Some other applications of Dijkstra’s algorithm include:

  1. Communicable disease transmission: Discover where biological diseases are spreading the fastest.
  2. Telephone networks: Routing calls to highest-bandwidth paths available in the network.
  3. Mapping: Finding the shortest and fastest paths for travelers.

  *-------------------Performance----------------
  * In Dijkstra’s algorithm, you constructed your graph using an adjacency list.
  * You used a min-priority queue to store vertices and extract the vertex with the minimum path.
  * This has an overall performance of O(log V).
  * This's because the heap operations of extracting the minimum element or inserting an element both take O(log V).
  * If you recall from the breadth-first search chapter, it takes O(V + E) to traverse all the vertices and edges.
  * Dijkstra’s algorithm is somewhat similar to breadth-first search, because you have to explore all neighboring edges.
  * This time, instead of going down to the next level, you use a min-priority queue to select a single vertex with the shortest distance to traverse down.
  * That means it is O(1 + E) or simply O(E). So, combining the traversal with operations on the min-priority queue, it takes O(E log V) to perform Dijkstra’s algorithm.

  *---------------------Key Points-----------------
  •  Dijkstra's algorithm finds a path to the rest of the nodes given a starting vertex.
  •  This algorithm is useful for finding the shortest paths between different endpoints.
  •  Visit state is used to track the edges back to the start vertex.
  •  The priority queue data structure helps to always return the vertex with the shortest path.
  •  Hence, it is a greedy algorithm!*/

class Dijkstra<T: Any>(private val graph: AdjacencyList<T>) {

  /*You need a mechanism to keep track of the total weight from the current vertex back
    to the start vertex. To do this, you'll keep track of a map named paths that stores a Visit state for every vertex.
    This method takes in the destination vertex along with a dictionary of existing
    paths, and it constructs a path that leads to the destination vertex.*/
  private fun route(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>): ArrayList<Edge<T>> {
    var vertex = destination //1-Start at the destination vertex.
    val path = arrayListOf<Edge<T>>() //2-Create a list of edges to store the path.

    loop@ while (true) {
      val visit = paths[vertex] ?: break

      when (visit.type) {
        VisitType.START -> break@loop //6-Once the while loop reaches the start case, you've completed the path and return it.
        VisitType.EDGE -> visit.edge?.let { //3-As long as you've not reached the start case, continue to extract the next edge.
          path.add(it) //4-Add this edge to the path.
          vertex = it.source //5-Set the current vertex to the edge’s source vertex. This moves you closer to the start vertex.
        }
      }
    }

    return path
  }

  /*This method takes in the destination vertex and a dictionary of existing paths, and it returns the total weight.
  * This simply takes the destination vertex and the map of shortest and returns the path to the destination vertex.*/
  private fun distance(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>): Double {
    val path = route(destination, paths) //1-Construct the path to the destination vertex.
    return path.sumByDouble { it.weight ?: 0.0 } //2-sumByDouble sums the weights of all the edges.
  }

  /*This method takes in a start vertex and returns a dictionary of all the paths.*/
  fun shortestPath(start: Vertex<T>): HashMap<Vertex<T>, Visit<T>> {
    val paths: HashMap<Vertex<T>, Visit<T>> = HashMap()
    paths[start] = Visit(VisitType.START) //1-Define paths and initialize it with the start vertex.

    //2-Create a Comparator which uses distances between vertices for sorting
    val distanceComparator = Comparator<Vertex<T>>({ first, second ->
      (distance(second, paths) - distance(first, paths)).toInt()
    })

    /*3-Use the previous Comparator and create a min-priority queue to store the
        vertices that must be visited.*/
    val priorityQueue = ComparatorPriorityQueueImpl(distanceComparator)
    //4-Enqueue the start vertex as the first vertex to visit.
    priorityQueue.enqueue(start)

    while (true) {
      /*1-You continue Dijkstra’s algorithm to find the shortest paths until you’ve visited all the vertices have been visited.
       This happens once the priority queue is empty.*/
      val vertex = priorityQueue.dequeue() ?: break
      val edges = graph.edges(vertex) //2-For the current vertex, you go through all its neighboring edges.

      edges.forEach {
        val weight = it.weight ?: return@forEach //3-You make sure the edge has a weight. If not, you move on to the next edge.

        if (paths[it.destination] == null
          || distance(vertex, paths) + weight < distance(it.destination, paths)) {
          /*4-If the destination vertex has not been visited before or you’ve found a cheaper
              path, you update the path and add the neighboring vertex to the priority queue.*/
          paths[it.destination] = Visit(VisitType.EDGE, it)
          priorityQueue.enqueue(it.destination)
        }
      }
    }

    //Once all the vertices have been visited, and the priority queue is empty, you return the map of shortest paths back to the start vertex.
    return paths
  }

  fun shortestPath(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>): ArrayList<Edge<T>> {
    return route(destination, paths)
  }

  /*--------------Challenge 2: Collect Dijkstra’s data---------------
  * This function is part of Dijkstra.kt. To get the shortest paths from the source vertex to every other vertex in the graph.*/
  fun getAllShortestPath(source: Vertex<T>): HashMap<Vertex<T>, ArrayList<Edge<T>>> {
    val paths = HashMap<Vertex<T>, ArrayList<Edge<T>>>() //1-The map stores the path to every vertex from the source vertex.
    val pathsFromSource = shortestPath(source) //2-Perform Dijkstra's algorithm to find all the paths from the source vertex.

    graph.vertices.forEach {//3-For every vertex in the graph, generate the list of edges between the source vertex to every vertex in the graph.
      val path = shortestPath(it, pathsFromSource)
      paths[it] = path
    }

    return paths //4-Return the map of paths.
  }

}

class Visit<T: Any>(val type: VisitType, val edge: Edge<T>? = null)

/*Here, you defined an enum named Visit. This keeps track of two states:
1. The vertex is the starting vertex.
2. The vertex has an associated edge that leads to a path back to the starting vertex.*/
enum class VisitType {

  START,
  EDGE

}