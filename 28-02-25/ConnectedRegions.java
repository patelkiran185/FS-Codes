import java.util.*;

public class ConnectedRegions {
    public static void main(String[] args) {
        int cities = 5; // Number of cities
        int[][] routes = { {0, 1}, {0, 2}, {1, 2}, {3, 4} }; // Given routes

        System.out.println("Number of regions: " + countRegions(cities, routes));
    }

    public static int countRegions(int cities, int[][] routes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < cities; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int[] route : routes) {
            int u = route[0], v = route[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[cities];
        int regions = 0;

        // Count connected components
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                regions++;
            }
        }

        return regions;
    }

    public static void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int neighbor : adjList.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}
