package be.pxl.dijkstra;

public class Demo2 {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addVertex("Hasselt");
        graph.addVertex("Genk");
        graph.addEdge("Hasselt", "Genk", 15);
    }
}
