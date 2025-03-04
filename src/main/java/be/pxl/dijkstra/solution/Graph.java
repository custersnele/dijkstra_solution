package be.pxl.dijkstra.solution;

import java.util.*;

public class Graph<T> {
    private final Map<T, Map<T, Integer>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(T source, T destination, int weight) {
        adjacencyMap.get(source).put(destination, weight);
        adjacencyMap.get(destination).put(source, weight); // For undirected graph
    }

    public Map<T, Integer> getNeighbours(T vertex) {
        return adjacencyMap.get(vertex);
    }

    public Set<T> getVertices() {
        return adjacencyMap.keySet();
    }

    public PathResult<T> shortestPath(T start, T end) {
        PriorityQueue<Node<T>> pq = new PriorityQueue<>();
        Set<T> visited = new HashSet<>();
        Map<T, PathResult<T>> paths = new HashMap<>();

        // Initialize distances
        for (T vertex : adjacencyMap.keySet()) {
            paths.put(vertex, new PathResult<>(new ArrayList<>(), Integer.MAX_VALUE));
        }
        paths.put(start, new PathResult<>(Collections.singletonList(start), 0));
        pq.offer(new Node<>(start, 0));

        while (!pq.isEmpty()) {
            Node<T> current = pq.poll();
            if (current.getVertex().equals(end)) {
                return paths.get(current.getVertex());
            }
            T currentVertex = current.getVertex();

            if (visited.contains(currentVertex)) {
                continue;
            }
            visited.add(currentVertex);

            for (Map.Entry<T, Integer> neighbour : getNeighbours(currentVertex).entrySet()) {
                T nextVertex = neighbour.getKey();
                PathResult<T> currentPath = paths.get(currentVertex);
                int newDist = currentPath.getDistance() + neighbour.getValue();

                if (newDist < paths.get(nextVertex).getDistance()) {
                    List<T> newPath = new ArrayList<>(currentPath.getVertices());
                    newPath.add(nextVertex);
                    paths.get(nextVertex).setPath(newPath, newDist);
                    pq.offer(new Node<>(nextVertex, newDist));
                }
            }
        }
        return null; // no path to end
    }
}
