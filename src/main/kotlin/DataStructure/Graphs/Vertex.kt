package DataStructure.Graphs


/*Here, you’ve defined a generic Vertex class. A vertex has a unique index within its
graph and holds a piece of data.

You defined Vertex as a data class because it will be used as a key in a Map later, and
a data class gives you equals() and hashCode() implementations, without having to write them yourself.*/
data class Vertex<T: Any>(val index: Int, val data: T)
