package be.pxl.dijkstra;

import java.util.List;

public class PathResult<T> {
    private final List<T> path;
    private final int distance;

    public PathResult(List<T> path, int distance) {
        this.path = path;
        this.distance = distance;
    }

    public List<T> getPath() {
        return path;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        path.forEach(v -> result.append(v).append(" -> "));
        result.append(": ").append(distance);
        return result.toString();
    }
}
