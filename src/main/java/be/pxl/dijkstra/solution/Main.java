package be.pxl.dijkstra.solution;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Example 1: Hard-coded example with integers
        Graph<Character> graph1 = new Graph<>();

        // Add vertices
        graph1.addVertex('A');
        graph1.addVertex('B');
        graph1.addVertex('C');
        graph1.addVertex('D');

        // Add edges
        graph1.addEdge('A', 'B', 2); // TODO aanpassen in tekening
        graph1.addEdge('B', 'C', 2);
        graph1.addEdge('C', 'D', 2);
        graph1.addEdge('A', 'D', 3);
        graph1.addEdge('A', 'C', 1);

        Map<Character, Integer> neighbours = graph1.getNeighbours('A');
        neighbours.forEach((k,v) -> System.out.println(k + " " + v));

        PathResult<Character> path = graph1.shortestPath('D', 'B');
        System.out.println(path);

    }
}
