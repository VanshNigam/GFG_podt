class Solution {
    int maxDist;         // store the maximum distance
    int farthestNode;    // store the farthest node

    // DFS to find farthest node and its distance
    void dfs(int node, int parent, int dist, List<List<Integer>> adj) {
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        for (int nei : adj.get(node)) {
            if (nei != parent) {
                dfs(nei, node, dist + 1, adj);
            }
        }
    }

    public int diameter(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 1: DFS from any node (say 0)
        maxDist = -1;
        dfs(0, -1, 0, adj);
        int nodeA = farthestNode;

        // Step 2: DFS from farthest node found
        maxDist = -1;
        dfs(nodeA, -1, 0, adj);

        // maxDist now contains the diameter
        return maxDist;
    }
}