package DataStructure.Graphs


//An Edge connects two vertices and has an optional weight.
data class Edge<T: Any>(val source: Vertex<T>, val destination: Vertex<T>, val weight: Double? = null)
