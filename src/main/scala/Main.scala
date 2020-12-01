object Main extends App {

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

  println("Hello World!")
}
