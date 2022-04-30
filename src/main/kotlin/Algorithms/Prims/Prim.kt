package Algorithms.Prims
import kotlin.Comparator
import kotlin.math.roundToInt

/* you’ve looked at depth-first and breadth-first search algorithms.
These algorithms form spanning trees.

A spanning tree is a subgraph of an undirected graph, containing all of the graph’s
vertices, connected with the fewest number of edges. A spanning tree cannot contain
a cycle and cannot be disconnected.

The priority queue is used to store the edges of the explored vertices. It’s a min-
priority queue so that every time you dequeue an edge, it gives you the edge with the
smallest weight.

------------------Performance--------------------
In the algorithm above, you maintain three data structures:
1. An adjacency list graph to build a minimum spanning tree. Adding vertices and
edges to an adjacency list is O(1) .
2. A Set to store all vertices you have visited. Adding a vertex to the set and
checking if the set contains a vertex also have a time complexity of O(1).
3. A min-priority queue to store edges as you explore more vertices. The priority
queue is built on top of a heap and insertion takes O(log E).

The worst-case time complexity of Prim’s algorithm is O(E log E).
This is because, each time you dequeue the smallest edge from the priority queue, you have to
traverse all the edges of the destination vertex ( O(E) ) and insert the edge into the
priority queue ( O(logE) ).*/
object Prim {

  /*Finding edges
  * This method takes in four parameters:
    1. The current vertex.
    2. The graph, wherein the current vertex is stored.
    3. The vertices that have already been visited.
    4. The priority queue to add all potential edges.*/
  private fun <T: Any> addAvailableEdges(
    vertex: Vertex<T>,
    graph: Graph<T>,
    visited: Set<Vertex<T>>,
    priorityQueue: AbstractPriorityQueue<Edge<T>>
  ) {
    graph.edges(vertex).forEach { edge -> //1-Look at every edge adjacent to the current vertex.
      if (edge.destination !in visited) { //2-Check to see if the destination vertex has already been visited.
        priorityQueue.enqueue(edge) //3-If it has not been visited, you add the edge to the priority queue.
      }
    }
  }

  /*1-produceMinimumSpanningTree takes an undirected graph and returns a minimum spanning tree and its cost.*/
  fun <T: Any> produceMinimumSpanningTree(graph: AdjacencyList<T>): Pair<Double, AdjacencyList<T>> {
    var cost = 0.0 //2-cost keeps track of the total weight of the edges in the minimum spanning tree.
    val mst = AdjacencyList<T>() //3-This is a graph that will become your minimum spanning tree.
    val visited = mutableSetOf<Vertex<T>>() //4-visited stores all vertices that have already been visited.
    val comparator = Comparator<Edge<T>> { first, second -> //5-You create the Comparator<Edge<T>> to use for the priority queue.
      val firstWeight = first.weight ?: 0.0
      val secondWeight = second.weight ?: 0.0
      (secondWeight - firstWeight).roundToInt()
    }
    val priorityQueue = ComparatorPriorityQueueImpl(comparator) //6-This is a min-priority queue to store edges.
    mst.copyVertices(graph) //7-Copy all the vertices from the original graph to the minimum spanning tree.

    val start = graph.vertices.firstOrNull() ?: return Pair(cost, mst) //8-Get the starting vertex from the graph.

    visited.add(start) //9-Mark the starting vertex as visited.
    addAvailableEdges(start, graph, visited, priorityQueue) //10-Add all potential edges from the start vertex into the priority queue.

    while (true) {
      val smallestEdge = priorityQueue.dequeue() ?: break //1-Continue Prim’s algorithm until the queue of edges is empty.
      val vertex = smallestEdge.destination //2-Get the destination vertex.
      if (vertex in visited) continue //3-If this vertex has been visited, restart the loop and get the next smallest edge.

      visited.add(vertex) //4-Mark the destination vertex as visited.
      cost += smallestEdge.weight ?: 0.0 //5-Add the edge’s weight to the total cost.

      //6-Add the smallest edge into the minimum spanning tree you are constructing.
      mst.add(EdgeType.UNDIRECTED, smallestEdge.source, smallestEdge.destination, smallestEdge.weight)

      //7-Add the available edges from the current vertex.
      addAvailableEdges(vertex, graph, visited, priorityQueue)
    }

    //8-Once the priorityQueue is empty, return the minimum cost, and minimum spanning tree.
    return Pair(cost, mst)
  }

}
