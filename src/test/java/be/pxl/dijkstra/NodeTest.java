package be.pxl.dijkstra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodeTest {

    @Test
    public void compareTo_returnsNegativeValue_ifDistanceIsSmaller() {
        Node<Character> node1 = new Node<>('A', 5);
        Node<Character> node2 = new Node<>('B', 9);
        assertTrue(node1.compareTo(node2) < 0);
    }

    @Test
    public void compareTo_returnsPositiveValue_ifDistanceIsGreater() {
        Node<Character> node1 = new Node<>('A', 9);
        Node<Character> node2 = new Node<>('B', 5);
        assertTrue(node1.compareTo(node2) > 0);
    }

    @Test
    public void compareTo_returnsZero_ifDistancesAreEqual() {
        Node<Character> node1 = new Node<>('A', 5);
        Node<Character> node2 = new Node<>('B', 5);
        assertEquals(0, node1.compareTo(node2));
    }
}
