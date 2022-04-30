package Algorithms.Dijkstras

/*This playground comes with an
adjacency list graph and a priority queue, which you'll use to implement Dijkstra’s algorithm.
The priority queue is used to store vertices that have not been visited.
It’s a min-priority queue so that, every time you dequeue a vertex, it gives you vertex with the
current tentative shortest path.*/
fun main() {
    val graph = AdjacencyList<String>()

    val a = graph.createVertex("A")
    val b = graph.createVertex("B")
    val c = graph.createVertex("C")
    val d = graph.createVertex("D")
    val e = graph.createVertex("E")

    graph.add(EdgeType.DIRECTED, a, b, 1.0)
    graph.add(EdgeType.DIRECTED, a, e, 21.0)
    graph.add(EdgeType.DIRECTED, a, c, 12.0)
    graph.add(EdgeType.DIRECTED, b, d, 9.0)
    graph.add(EdgeType.DIRECTED, b, c, 8.0)
    graph.add(EdgeType.DIRECTED, d, e, 2.0)
    graph.add(EdgeType.DIRECTED, c, e, 2.0)

    /*Here, you simply create an instance of Dijkstra by passing in the graph network*/
    val dijkstra = Dijkstra(graph)
    val pathsFromA = dijkstra.getAllShortestPath(a)

    pathsFromA.forEach { (vertex, path) ->
        println("Path to ${vertex.data} from ${a.data}")
        path.forEach {
            println("${it.source.data} --|${it.weight ?: 0.0}|--> ${it.destination.data}")
        }
        println()
    }
}