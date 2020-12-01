import scala.collection.immutable.Queue

object Traversal {

  /** traverse the graph using depth-first search recursively
    *
    * @param start
    * @param graph
    * @param action
    * @param visited
    * @return
    */
  def traversalDFS[V](
      start: V,
      graph: Graph[V],
      action: V => Unit,
      visited: Set[V] = Set[V]()
  ): Set[V] = {
    if (visited.contains(start)) {
      visited
    } else {
      action(start)
      graph
        .neighbours(start)
        .foldLeft(visited + start)((allVisited, next) =>
          traversalDFS(next, graph, action, allVisited)
        )
    }
  }

  /** depth-first search traverse the graph iteratively
    *
    * @param start
    * @param graph
    * @param action
    */
  def traversalDFSAlt[V](start: V, graph: Graph[V], action: V => Unit): Unit = {
    LazyList
      .iterate((List(start), Set[V](start))) {
        case (stk, visited) => {
          val vertex = stk.head
          /* push all the neighbours that has not been visited */
          val newStack =
            graph.neighbours(vertex).filterNot(visited.contains) ++ stk.tail
          /* tag all the neighbours as visited */
          val newVisited = graph.neighbours(vertex).toSet ++ visited
          (newStack, newVisited)
        }
      }
      .takeWhile { case (newStack, newVisited) =>
        newStack.nonEmpty
      }
      .foreach { case (newStack, newVisited) => action(newStack.head) }
  }

  /** breadth-first search traverse the graph iteratively
    * 
    *
    * @param start
    * @param graph
    * @param action
    */
  def traversalBFS[V](start: V, graph: Graph[V], action: V => Unit): Unit = {
    LazyList
      .iterate((Queue(start), Set[V](start))) {
        case (q, visited) => {
          val (vertex, rest) = q.dequeue
          /* enqueue all the neighbours that has not been visited */
          val newQueue =
            rest.enqueueAll(
              graph.neighbours(vertex).filterNot(visited.contains)
            )
          /* tag all the neighbours as visited */
          val newVisited = graph.neighbours(vertex).toSet ++ visited
          (newQueue, newVisited)
        }
      }
      .takeWhile { case (newQueue, newVisited) =>
        newQueue.nonEmpty
      }
      .foreach { case (newQueue, newVisited) => action(newQueue.head) }
  }

}
