package Tasks;

public class UnionFind {

	private int[] parent;

    // Constructor to initialize the parent array
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Each node is its own parent initially
        }
    }

    // Find the root of the set containing x with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }

    // Union the sets containing x and y
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;  // Attach one tree under the root of the other
        }
    }

    // Method to detect a cycle in an undirected graph
    public boolean hasCycle(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) {
                return true;  // A cycle is detected
            }

            union(u, v);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };  // Example graph with a cycle
        UnionFind uf = new UnionFind(3);

        if (uf.hasCycle(edges)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
