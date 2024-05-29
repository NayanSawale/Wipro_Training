package Tasks;

import java.util.*;
public class Dijkstra {

	static class Node implements Comparable<Node> {
        String name;
        int distance;

        Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        // Priority queue for the min-heap
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        
        // Distances map
        Map<String, Integer> distances = new HashMap<>();
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        
        // Visited set
        Set<String> visited = new HashSet<>();
        
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            String currentName = currentNode.name;
            
            // Skip if visited
            if (visited.contains(currentName)) {
                continue;
            }
            
            // Mark as visited
            visited.add(currentName);
            
            // Update distances to neighbors
            for (Map.Entry<String, Integer> neighborEntry : graph.get(currentName).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
                int newDist = distances.get(currentName) + weight;
                
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    priorityQueue.add(new Node(neighbor, newDist));
                }
            }
        }
        
        return distances;
    }

    public static void main(String[] args) {
        // Example graph
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        
        graph.put("A", new HashMap<>(Map.of("B", 1, "C", 4)));
        graph.put("B", new HashMap<>(Map.of("A", 1, "C", 2, "D", 5)));
        graph.put("C", new HashMap<>(Map.of("A", 4, "B", 2, "D", 1)));
        graph.put("D", new HashMap<>(Map.of("B", 5, "C", 1)));
        
        String startNode = "A";
        Map<String, Integer> shortestPaths = dijkstra(graph, startNode);
        
        System.out.println("Shortest paths from node " + startNode + ": " + shortestPaths);
    }

}
