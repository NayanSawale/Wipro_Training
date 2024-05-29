package com.task;


import java.util.*;

public class DirectedGraph {

	private Map<Integer, List<Integer>> adjList;

    public DirectedGraph() {
        adjList = new HashMap<>();
    }

    // Method to add an edge if it doesn't create a cycle
    public boolean addEdge(int from, int to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        
        // Temporarily add the edge
        adjList.get(from).add(to);

        // Check for cycles
        if (hasCycle()) {
            // If a cycle is detected, remove the edge and return false
            adjList.get(from).remove((Integer) to);
            return false;
        }

        // No cycle detected, edge added successfully
        return true;
    }

    // Method to detect if there is a cycle in the graph
    private boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (hasCycleUtil(node, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    // Utility method for cycle detection using DFS
    private boolean hasCycleUtil(int node, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recStack.add(node);

        for (int neighbor : adjList.get(node)) {
            if (hasCycleUtil(neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(node);
        return false;
    }

    // Main method to test the DirectedGraph implementation
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

        // Adding edges and checking for cycles
        System.out.println(graph.addEdge(1, 2)); // true
        System.out.println(graph.addEdge(2, 3)); // true
        System.out.println(graph.addEdge(3, 4)); // true
        System.out.println(graph.addEdge(4, 2)); // false (creates a cycle)
    }

}
