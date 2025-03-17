package be.pxl.dijkstra.cities;

import be.pxl.dijkstra.Graph;
import be.pxl.dijkstra.PathResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Cities {

    public static void main(String[] args) throws IOException {
        Graph<String> cityGraph = readCitiesFromFile(Path.of("src/main/resources/cities.txt"));
        Map<String, Integer> neighbours = cityGraph.getNeighbours("Madrid");
        neighbours.forEach((k,v) -> System.out.println(k + " " + v));

        PathResult<String> path = cityGraph.shortestPath("Madrid", "Paris");
        System.out.println(path);
    }

    private static Graph<String> readCitiesFromFile(Path filename) throws IOException {
        Graph<String> graph = new Graph<>();
        List<String> lines = Files.readAllLines(filename);
        for (String line : lines) {
            String[] parts = line.split(",");
            String city1 = parts[0].trim();
            String city2 = parts[1].trim();
            int distance = Integer.parseInt(parts[2].trim());

            graph.addVertex(city1);
            graph.addVertex(city2);
            graph.addEdge(city1, city2, distance);
        }
        return graph;
    }
}
