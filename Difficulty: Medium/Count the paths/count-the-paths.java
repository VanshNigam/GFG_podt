class Solution {
    
    public int dfs(int u){
        if(u==destination)return 1;
        if(dp[u]!=-1)return dp[u];
        
        int c=0;
        for(int neigh:adj.get(u)){
            c+=dfs(neigh);
        }
        return dp[u]=c;
    }
    
    int[] dp;
    ArrayList<ArrayList<Integer>> adj;
    int destination;
    
    public int countPaths(int[][] edges, int V, int src, int dest) {
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        destination = dest;
        dp = new int[V];
        Arrays.fill(dp, -1);
        return dfs(src);
    }
}