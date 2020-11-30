trait Graph[V] {
  def vertices: List[V]

  def edges: List[(V, V)]

  def addEdge(a: V, b: V): Graph[V]

  def neighbours(vertex: V): List[V]
}

object Graph {

  /** Creates a directed graph based on an adjacency list
    *
    * @param adjList
    * @return
    */
  def apply[V](adjList: Map[V, List[V]]): Graph[V] =
    new DirectedGraph[V](adjList)

  /** Creates an empty directed graph
    *
    * @return
    */
  def apply[V](): Graph[V] =
    new DirectedGraph[V](Map[V, List[V]]())
}
