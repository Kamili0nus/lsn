package io.lsn.task.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Node, LinkedList<Node>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(Node source, Node destination) {
        adjacencyList.putIfAbsent(source, new LinkedList<>(List.of(destination)));
        if (!adjacencyList.get(source).contains(destination)) {
            adjacencyList.get(source).add(destination);
        }

        adjacencyList.putIfAbsent(destination, new LinkedList<>(List.of(source)));
        if (!adjacencyList.get(destination).contains(source)) {
            adjacencyList.get(destination).add(source);
        }
    }
    private void DFS(Node node) {
        node.markVisit();
        for (Node nextNode : adjacencyList.get(node)) {
            if (!nextNode.isVisited()) {
                DFS(nextNode);
            }
        }
    }

    public int graphCounter() {
        int counter = 0;

        for (Node node : adjacencyList.keySet()) {
            if (!node.isVisited()) {
                DFS(node);
                counter++;
            }
        }
        return counter;
    }
}
