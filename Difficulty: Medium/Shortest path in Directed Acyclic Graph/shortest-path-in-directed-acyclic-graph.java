// User function Template for Java
import java.util.*;

class Solution {

    // 🔹 DFS-based Topological Sort
    private void topoSort(int node, ArrayList<ArrayList<int[]>> adj,
                          int vis[], Stack<Integer> st) {
        vis[node] = 1;
        for (int neigh[] : adj.get(node)) {
            int v = neigh[0];
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        // after visiting all neighbours, push current node
        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // 🔹 Step 1: Build adjacency list [neigh, weight]
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
        }

        // 🔹 Step 2: Get Topological Order using DFS
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        // 🔹 Step 3: Initialize distances
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0; // source = 0

        // 🔹 Step 4: Relax edges in Topological Order
        while (!st.isEmpty()) {
            int pop = st.pop();
            if (dis[pop] != Integer.MAX_VALUE) { // avoid overflow
                for (int neigh[] : adj.get(pop)) {
                    int v = neigh[0];
                    int wt = neigh[1];
                    if (dis[pop] + wt < dis[v]) {
                        dis[v] = dis[pop] + wt;
                    }
                }
            }
        }

        // 🔹 Step 5: Mark unreachable nodes as -1
        for (int i = 0; i < V; i++) {
            if (dis[i] == Integer.MAX_VALUE) dis[i] = -1;
        }

        return dis;
    }
}
