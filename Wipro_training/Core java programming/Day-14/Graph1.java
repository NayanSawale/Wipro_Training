package com.Tasks;

import java.util.*;
public class Graph1 
 {
    private List<List<Integer>> adjList;

    // Constructor to initialize the graph with a given number of vertices
    public Graph1(int numVertices) {
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph (undirected graph)
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // For undirected graph, add edge in both directions
    }

    // Method to start DFS traversal from a given starting vertex
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[adjList.size()];
        dfsRecursive(startVertex, visited);
    }

    // Recursive helper method for DFS traversal
    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    // Main method to test the DFS implementation
    public static void main(String[] args) {
        Graph1 graph = new Graph1(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("DFS starting from vertex 0:");
        graph.dfs(0);
    }
}


