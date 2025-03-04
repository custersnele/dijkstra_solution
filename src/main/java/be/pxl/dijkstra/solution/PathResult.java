package be.pxl.dijkstra.solution;

import java.util.List;

public class PathResult<T> {
    private List<T> vertices;
    private int distance;

    public PathResult(List<T> vertices, int distance) {
        this.vertices = vertices;
        this.distance = distance;
    }

    public void setPath(List<T> vertices, int distance) {
        this.vertices = vertices;
        this.distance = distance;
    }

    public List<T> getVertices() {
        return vertices;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        vertices.forEach(v -> result.append(v).append(" "));
        result.append("\n").append(distance);
        return result.toString();
    }
}
