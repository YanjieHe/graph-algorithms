import org.scalatest.FunSuite

class GraphTests extends FunSuite {
  test("correctly creates a directed graph") {
    val g = Graph[String]()
      .addEdge("London", "Lisbon")
      .addEdge("Lisbon", "Madrid")
      .addEdge("Madrid", "London")
      .addEdge("Madrid", "Rome")
      .addEdge("Rome", "London")
      .addEdge("Paris", "Rome")

    assert(g.neighbours(vertex = "Madrid").toSet == Set("London", "Rome"))
  }
  test("traversal") {
    val g = Graph[String]()
      .addEdge("A", "B")
      .addEdge("B", "C")
      .addEdge("C", "E")
      .addEdge("C", "D")
      .addEdge("A", "G")
      .addEdge("G", "H")
      .addEdge("H", "F")
      .addEdge("F", "A")
      .addEdge("D", "E")

    def recordTrace(traveller: (String => Unit) => Unit): List[String] = {
      var list: List[String] = Nil
      traveller((v: String) => (list = v :: list))
      list.reverse
    }
    assert(
      recordTrace((action) => Traversal.traversalDFS("A", g, action)) ==
        List("A", "G", "H", "F", "B", "C", "D", "E")
    )
    assert(
      recordTrace((action) => Traversal.traversalDFSAlt("A", g, action)) ==
        List("A", "G", "H", "F", "B", "C", "D", "E")
    )
    assert(
      recordTrace((action) => Traversal.traversalBFS("A", g, action)) ==
        List("A", "G", "B", "H", "C", "F", "D", "E")
    )
  }
}
