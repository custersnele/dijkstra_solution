package be.pxl.dijkstra;

import java.util.*;

public class Graph<T> {

    private final Map<T, Map<T, Integer>> adjacencyMap = new HashMap<>();

    public void addVertex(T vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(T v1, T v2, int distance) {
        if (adjacencyMap.get(v1) == null) {
            throw new IllegalArgumentException("Missing vertex " + v1);
        }
        if (adjacencyMap.get(v2) == null) {
            throw new IllegalArgumentException("Missing vertex " + v2);
        }
        adjacencyMap.get(v1).putIfAbsent(v2, distance);
        adjacencyMap.get(v2).putIfAbsent(v1, distance);
    }

    public Map<T, Integer> getNeighbours(T vertex) {
        return adjacencyMap.get(vertex);
    }

    public Set<T> getVertices() {
        return adjacencyMap.keySet();
    }

    public PathResult<T> shortestPath(T start, T end) {
        // Maak een PriorityQueue pq (min-heap) voor knopen (vertex, distance)
        PriorityQueue<Node<T>> pq = new PriorityQueue<>();
        // Maak een Set visited voor bezochte knopen
        Set<T> visited = new HashSet<>();
        // Maak een Map paths om de kortste afstanden en paden bij te houden (PathResult)
        Map<T, PathResult<T>> paths = new HashMap<>();

        // Initialisatie van afstanden en paden
        //  Voor elke knoop in de graaf: paths[knoop] = (∞, lege lijst)
        for (T vertex : adjacencyMap.keySet()) {
            paths.put(vertex, new PathResult<>(new ArrayList<>(), Integer.MAX_VALUE));
        }
        // paths[start] = (0, [start])
        paths.put(start, new PathResult<>(Collections.singletonList(start), 0));
        // Voeg (start, 0) toe aan pq
        pq.offer(new Node<>(start, 0));

        //  Terwijl pq niet leeg is:
        while (!pq.isEmpty()) {
            // Huidige knoop = verwijder knoop met kleinste afstand uit pq
            Node<T> current = pq.poll();
            // Als huidige knoop == end: kortste path gevonden en return paths[end]
            if (current.getVertex().equals(end)) {
                return paths.get(current.getVertex());
            }
            T currentVertex = current.getVertex();

            // Als huidige knoop al bezocht is: Ga verder met volgende iteratie
            if (visited.contains(currentVertex)) {
                continue;
            }
            // Voeg huidige knoop toe aan visited
            visited.add(currentVertex);

            // Voor elke buur van huidige knoop:
            for (Map.Entry<T, Integer> neighbour : getNeighbours(currentVertex).entrySet()) {
                T nextVertex = neighbour.getKey();
                PathResult<T> currentPath = paths.get(currentVertex);
                // Bereken nieuwe afstand = huidige afstand + afstand naar buur
                int newDistance = currentPath.getDistance() + neighbour.getValue();

                // Als nieuwe afstand korter is dan de huidige opgeslagen afstand:
                // Werk paths[buur] bij met het nieuwe pad en afstand
                // Voeg buur toe aan pq met nieuwe afstand
                if (newDistance < paths.get(nextVertex).getDistance()) {
                    List<T> newPath = new ArrayList<>(currentPath.getPath());
                    newPath.add(nextVertex);
                    paths.put(nextVertex, new PathResult<>(newPath, newDistance));
                    pq.offer(new Node<>(nextVertex, newDistance));
                }
            }
        }
        return null; // Geen pad gevonden
    }
}
