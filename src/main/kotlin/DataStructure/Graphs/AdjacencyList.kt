package DataStructure.Graphs

//Here, you’ve defined an AdjacencyList that uses a map to store the edges.
class AdjacencyList<T: Any> : Graph<T> {

  private val adjacencies: HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()

  //Here, you create a new vertex and return it. In the adjacency list, you store an empty list of edges for this new vertex.
  override fun createVertex(data: T): Vertex<T> {
    val vertex = Vertex(adjacencies.count(), data)
    adjacencies[vertex] = ArrayList()
    return vertex
  }

  //This method creates a new edge and stores it in the adjacency list.
  override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
    val edge = Edge(source, destination, weight)
    adjacencies[source]?.add(edge)
  }

  /*Retrieving the outgoing edges from a vertex.
   This is a straightforward implementation: You either return the stored edges or an empty list if the source vertex is unknown.*/
  override fun edges(source: Vertex<T>) = adjacencies[source] ?: arrayListOf()

  /*Retrieving the weight of an edge
  * Here, you find the first edge from source to destination; if there is one, you return its weight.*/
  override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
    return edges(source).firstOrNull { it.destination == destination }?.weight
  }

  override fun toString(): String {
    return buildString {//1-You'll be assembling the result using buildString(), which places you inside the scope of a StringBuilder, and returns whatever you've built.
      adjacencies.forEach { (vertex, edges) -> //2-You loop through every key-value pair in adjacencies.
        val edgeString = edges.joinToString { it.destination.data.toString() } //3-For every vertex, you create a string representation of all its outgoing edges. joinToString() gives you a neat, comma-separated list of the items.
        append("${vertex.data} ---> [ $edgeString ]\n") //4-Finally, for every vertex, you append both the vertex itself and its outgoing edges to the StringBuilder that buildString() provides you with.
      }
    }
  }




}