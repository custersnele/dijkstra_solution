package be.pxl.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
    private Map<T, Map<T, Integer>> adjacencyMap = new HashMap<>();

    public void addVertex(T vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(T v1, T v2, int distance) {
        adjacencyMap.get(v1).putIfAbsent(v2, distance);
        adjacencyMap.get(v2).putIfAbsent(v1, distance);
    }

    public Map<T, Integer> getNeighbours(T vertex) {
        return adjacencyMap.get(vertex);
    }

    public Set<T> getVertices() {
        return adjacencyMap.keySet();
    }

}
