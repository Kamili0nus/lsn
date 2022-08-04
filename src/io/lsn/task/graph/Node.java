package io.lsn.task.graph;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private static final Map<Integer, Node> nodes = new HashMap<>();
    private final int value;
    private boolean visited = false;

    private Node(int value) {
        this.value = value;
    }

    public static Node getInstance(int value) {
        if (Integer.signum(value) != 1) throw new IllegalArgumentException();
        if (nodes.containsKey(value)) return nodes.get(value);
        else {
            Node newNode = new Node(value);
            nodes.put(value, newNode);
            return newNode;
        }
    }

    public boolean isVisited() {
        return visited;
    }

    public void markVisit() {
        visited = true;
    }
}
