package be.pxl.dijkstra;

public class Node<T> implements Comparable<Node<T>> {
    private final T vertex;
    private final int distance;

    public Node(T vertex, int distance) {
        this.distance = distance;
        this.vertex = vertex;
    }

    public int getDistance() {
        return distance;
    }

    public T getVertex() {
        return vertex;
    }

    @Override
    public int compareTo(Node<T> o) {
        return Integer.compare(this.distance, o.distance);
    }
}
