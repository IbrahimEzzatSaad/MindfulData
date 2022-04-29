package DataStructure.Graphs



/*Here, you’ve defined an AdjacencyMatrix that contains an array of vertices and an
  adjacency matrix to keep track of the edges and their weights.*/
class AdjacencyMatrix<T: Any> : Graph<T> {

  private val vertices = arrayListOf<Vertex<T>>()
  private val weights = arrayListOf<ArrayList<Double?>>()

  override fun createVertex(data: T): Vertex<T> {
    val vertex = Vertex(vertices.count(), data)
    vertices.add(vertex) //1-Add a new vertex to the array.
    weights.forEach {
      it.add(null) //2-Append a null weight to every row in the matrix, as none of the current vertices have an edge to the new vertex.
    }
    val row = ArrayList<Double?>(vertices.count())
    repeat(vertices.count()) {
      row.add(null)
    }
    weights.add(row) //3-Add a new row to the matrix. This row holds the outgoing edges for the new vertex. You put a null value in this row for each vertex that your graph stores.
    return vertex
  }

  override fun addDirectedEdge(
    source: Vertex<T>,
    destination: Vertex<T>,
    weight: Double?
  ) {
    weights[source.index][destination.index] = weight
  }

  /*To retrieve the outgoing edges for a vertex, you search the row for this vertex in the
    matrix for weights that are not null.

    Every non-null weight corresponds with an outgoing edge. The destination is the
    vertex that corresponds with the column in which the weight was found.*/
  override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
    val edges = arrayListOf<Edge<T>>()
    (0 until weights.size).forEach { column ->
      val weight = weights[source.index][column]
      if (weight != null) {
        edges.add(Edge(source, vertices[column], weight))
      }
    }
    return edges
  }

  override fun weight(
    source: Vertex<T>,
    destination: Vertex<T>
  ): Double? {
    return weights[source.index][destination.index]
  }

  override fun toString(): String {
    //1-You first create a list of the vertices.
    val verticesDescription = vertices
      .joinToString(separator = "\n") { "${it.index}: ${it.data}" }

    //2-Then, you build up a grid of weights, row by row.
    val grid = weights.map { row ->
      buildString {
        (0 until weights.size).forEach { columnIndex ->
          val value = row[columnIndex]
          if (value != null) {
            append("$value\t")
          } else {
            append("ø\t\t")
          }
        }
      }
    }

    val edgesDescription = grid.joinToString("\n")
    //3-Finally, you join both descriptions together and return them.
    return "$verticesDescription\n\n$edgesDescription"
  }

}