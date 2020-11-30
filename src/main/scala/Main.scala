object Main extends App {
  // val g = Graph[String]()
  //   .addEdge("London", "Lisbon")
  //   .addEdge("Lisbon", "Madrid")
  //   .addEdge("Madrid", "London")
  //   .addEdge("Madrid", "Rome")
  //   .addEdge("Rome", "London")
  //   .addEdge("Paris", "Rome")

  // println(g.vertices)
  // println(g.neighbours(vertex = "Madrid"))

  // val g = Graph[String]()
  //   .addEdge("A", "B")
  //   .addEdge("B", "C")
  //   .addEdge("C", "E")
  //   .addEdge("C", "D")
  //   .addEdge("A", "G")
  //   .addEdge("G", "H")
  //   .addEdge("H", "F")
  //   .addEdge("F", "A")
  //   .addEdge("D", "E")

  // Traversal.traversalDFS("A", g, println)
  // Traversal.traversalDFSAlt("A", g, println)
  // Traversal.traversalBFS("A", g, println)

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

  val list0 = List[Int]()
  val list1 = List[Int](1, 2, 3, 4, 5)

  list1.exists(n => n > 3)
  list1.forall(n => n > 3)
}
