object Main extends App {
  def test1(): Unit = {
    val g = Graph[String]()
      .addEdge("London", "Lisbon")
      .addEdge("Lisbon", "Madrid")
      .addEdge("Madrid", "London")
      .addEdge("Madrid", "Rome")
      .addEdge("Rome", "London")
      .addEdge("Paris", "Rome")

    println(g.vertices)
    println(g.neighbours(vertex = "Madrid"))
  }

  def test2(): Unit = {
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

    Traversal.traversalDFS("A", g, println)
    Traversal.traversalDFSAlt("A", g, println)
    Traversal.traversalBFS("A", g, println)
  }

  def test3(): Unit = {
    val g: Graph[String] = Graph()
      .addEdge("Logging", "Game")
      .addEdge("Logging", "Networking")
      .addEdge("Networking", "Game")
      .addEdge("Commons", "Physics")
      .addEdge("Commons", "Math")
      .addEdge("Math", "Physics")
      .addEdge("Math", "Graphics")
      .addEdge("Math", "AI Engine")
      .addEdge("Physics", "Game")
      .addEdge("Graphics", "Game")
      .addEdge("AI Engine", "Game")

    println(TopologicalSort.topologicalSort(g))
  }

  test2()
  println("Hello World!")
}
