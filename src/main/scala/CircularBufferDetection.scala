object CircularBufferDetection {
  private def moveOnce[V](stack: List[V], graph: Graph[V]): List[V] = {
    stack.headOption.map(v => graph.neighbours(v) ++ stack.tail).getOrElse(Nil)
  }

  def containsCycleFloyd[V](startVertex: V, graph: Graph[V]): Boolean = {
    val tortoise =
      Stream.iterate((List(startVertex)))(vList => moveOnce(vList, graph))
    val hare =
      Stream.iterate((List(startVertex)))(vList => moveOnce(vList, graph))
  }
}
