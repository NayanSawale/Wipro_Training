package tasks;

public class TravelingSalesman {

	 
    // Function to solve the TSP using Dynamic Programming
    public static int FindMinCost(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1;
        int[][] dp = new int[1 << n][n];

        // Initialize dp array with a large value
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case: starting from the first city
        dp[1][0] = 0;

        // Iterate over all subsets of cities
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                // Continue if the ith city is not in the subset represented by mask
                if ((mask & (1 << i)) == 0) continue;

                // Try to find the minimum cost path to city i
                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) != 0 && i != j) {
                        dp[mask][i] = Math.min(dp[mask][i], dp[mask ^ (1 << i)][j] + graph[j][i]);
                    }
                }
            }
        }

        // Find the minimum cost to visit all cities and return to the starting city
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minCost = Math.min(minCost, dp[VISITED_ALL][i] + graph[i][0]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("The minimum cost is " + FindMinCost(graph));
    }

}
