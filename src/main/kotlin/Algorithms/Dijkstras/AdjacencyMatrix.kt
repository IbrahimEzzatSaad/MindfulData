package Algorithms.Dijkstras


class AdjacencyMatrix<T: Any> : Graph<T>() {

  private val vertices = arrayListOf<Vertex<T>>()
  private val weights = arrayListOf<ArrayList<Double?>>()

  override fun createVertex(data: T): Vertex<T> {
    val vertex = Vertex(vertices.count(), data)
    vertices.add(vertex)
    weights.forEach {
      it.add(null)
    }
    weights.add(arrayListOf())
    return vertex
  }

  override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
    val row = weights[source.index]
    if (row.size <= destination.index) {
      (row.size..destination.index).forEach {
        row.add(it, null)
      }
    }
    row[destination.index] = weight
  }

  override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
    val edges = arrayListOf<Edge<T>>()
    (0 until weights.size).forEach {
      val weight = weights[source.index][it]
      if (weight != null) edges.add(Edge(source, vertices[it], weight))
    }
    return edges
  }

  override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
    return weights[source.index][destination.index]
  }

  override fun toString(): String {
    val verticesDescription = vertices.joinToString("\n") { "${it.index}: ${it.data}" }

    val grid = arrayListOf<String>()
    weights.forEach {
      var row = ""
      (0 until weights.size).forEach { columnIndex ->
        if (columnIndex >= it.size) {
          row += "ø\t\t"
        } else {
          row += it[columnIndex]?.let { "$it\t" } ?: "ø\t\t"
        }
      }
      grid.add(row)
    }
    val edgesDescription = grid.joinToString("\n")
    return "$verticesDescription\n\n$edgesDescription"
  }

}