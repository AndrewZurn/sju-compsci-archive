package SixDegrees;
import SixDegrees.graph.LabeledGraph;
public class TestWeightedGraph {
  LabeledGraph<String,Integer> g=
    new LabeledGraph<String,Integer>();
  public TestWeightedGraph() {
    g.addEdge("A","B",12);
    g.addEdge("B","C",10);
    g.addEdge("D","E",16);
    g.addEdge("B","C",19);
    g.addEdge("B","D",14);
    g.addEdge("C","E",17);
    g.addEdge("D","G",62);
    g.addEdge("D","F",64);
    g.addEdge("F","G",92);
    g.addEdge("D","H",93);
    System.out.println(g);
  }
  public static void main(String[] args) {
    new TestWeightedGraph();
  }
}