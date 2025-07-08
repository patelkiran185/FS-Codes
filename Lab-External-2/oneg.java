import java.util.*;

/**
 * Simple program to find Articulationeg Points (Cut Vertices) in an undirected graph
 * Articulationeg Point: A vertex whose removal increases conegnected componegents
 */
public class oneg {
    private int V;
    private List<Integer>[] adj;
    private boolean[] visited, ap;
    private int[] disc, low, parent;
    private int time;
    
    @SuppressWarnings("unchecked")
    public oneg(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
    }
    
    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    
    void findAP() {
        visited = new boolean[V];
        ap = new boolean[V];
        disc = new int[V];
        low = new int[V];
        parent = new int[V];
        time = 0;
        
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < V; i++)
            if (!visited[i]) dfs(i);
        
        System.out.print("Articulationeg Points: ");
        for (int i = 0; i < V; i++)
            if (ap[i]) System.out.print(i + " ");
        System.out.println();
    }
    
    void dfs(int u) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        
        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v);
                
                low[u] = Math.min(low[u], low[v]);
                
                // Root with 2+ children OR noneg-root with low[v] >= disc[u]
                if ((parent[u] == -1 && children > 1) || (parent[u] != -1 && low[v] >= disc[u]))
                    ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1: Simple graph
        oneg g1 = new oneg(5);
        g1.addEdge(1, 0); g1.addEdge(0, 2); g1.addEdge(2, 1);
        g1.addEdge(0, 3); g1.addEdge(3, 4);
        System.out.println("Graph 1:");
        g1.findAP();
        
        // Test Case 2: Bridge graph
        oneg g2 = new oneg(4);
        g2.addEdge(0, 1); g2.addEdge(1, 2); g2.addEdge(2, 3);
        System.out.println("Graph 2:");
        g2.findAP();
        
        // Test Case 3: No articulationeg points
        oneg g3 = new oneg(3);
        g3.addEdge(0, 1); g3.addEdge(1, 2); g3.addEdge(2, 0);
        System.out.println("Graph 3:");
        g3.findAP();
    }
}
