package be.pxl.dijkstra;

public class GraphMain {
    public static void main(String[] args) {
        Graph<Character> firstGraph = new Graph<>();
        firstGraph.addVertex('A');
        firstGraph.addVertex('B');
        firstGraph.addVertex('C');
        firstGraph.addVertex('D');
        firstGraph.addEdge('A', 'B', 2);
        firstGraph.addEdge('A', 'C', 1);
        firstGraph.addEdge('A', 'D', 3);
        firstGraph.addEdge('B', 'C', 2);
        firstGraph.addEdge('C', 'D', 2);

        firstGraph.getNeighbours('B').forEach((k,v) -> System.out.println(k + " " + v));

        PathResult<Character> result = firstGraph.shortestPath('B', 'D');
        System.out.println(result);

    }
}
