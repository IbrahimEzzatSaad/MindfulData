package Algorithms.DepthFirstSearch

fun main() {
    val graph = AdjacencyList<String>()
    val a = graph.createVertex("A")
    val b = graph.createVertex("B")
    val c = graph.createVertex("C")
    val d = graph.createVertex("D")

    graph.add(EdgeType.DIRECTED, a, b, null)
    graph.add(EdgeType.DIRECTED, a, c, null)
    graph.add(EdgeType.DIRECTED, b, c, null)
    graph.add(EdgeType.DIRECTED, c, d, null)

    val vertices = graph.depthFirstSearchRecursive(a) // 2
    vertices.forEach {
        println(it.data)
    }

    println(graph.hasCycle(a))

    graph.add(EdgeType.DIRECTED, c, a, null) // make a cycle

    println(graph.hasCycle(a))
}