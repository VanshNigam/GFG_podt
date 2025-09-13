class Solution {
    private boolean dfs(int vis[],ArrayList<ArrayList<Integer>>adj,int i,int parent)
    {
        vis[i]=1;
        for(int neigh:adj.get(i)){
            if(vis[neigh]==0) {if(dfs(vis,adj,neigh,i))return true;}
            else if(neigh!=parent)return true;
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:edges){
            adj.get(i[1]).add(i[0]);
            adj.get(i[0]).add(i[1]);
        }
        
        int vis[]=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0)
            {
                if(dfs(vis,adj,i,-1))return true;
            }
        }
        return false;
    }
}