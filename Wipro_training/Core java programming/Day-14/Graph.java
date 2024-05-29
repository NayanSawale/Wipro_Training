package com.Tasks;

import java.util.*;
public class Graph {

	private List<List<Integer>> adjList;

    // Constructor to initialize the graph with a given number of vertices
    public Graph(int numVertices) {
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

    // Method to perform BFS traversal from a given starting vertex
    public void bfs(int startVertex) {
        int totalVertices = adjList.size();
        boolean[] visited = new boolean[totalVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Main method to test the BFS implementation
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("BFS starting from vertex 0:");
        graph.bfs(0);
    }
}
