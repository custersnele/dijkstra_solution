package be.pxl.dijkstra;

public class Demo1 {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge('A', 'B', 2);
        graph.addEdge('B', 'C', 2);
        graph.addEdge('A', 'C', 1);
        graph.addEdge('A', 'D', 3);
        graph.addEdge('C', 'D', 2);

        graph.getNeighbours('A')
                .forEach((key, value) -> System.out.println(key + " " + value));

    }
}
