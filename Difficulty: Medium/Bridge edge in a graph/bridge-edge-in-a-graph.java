//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    
    public void dfs(Map<Integer,Boolean>vis,ArrayList<ArrayList<Integer>>adj,int curr){
        vis.put(curr,true);
        
        for(int neigh:adj.get(curr)){
            if(!vis.containsKey(neigh)){
                dfs(vis,adj,neigh);
            }
        }
    }
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int i[]:edges){
            if(c==i[0] && d==i[1])continue;
            
            ArrayList<Integer>t=adj.get(i[0]);
            t.add(i[1]);
            
            ArrayList<Integer>t1=adj.get(i[1]);
            t1.add(i[0]);
        }
        
        Map<Integer,Boolean>vis=new HashMap<>();
        
        dfs(vis,adj,c);
        
        if(vis.containsKey(d))return false;
        return true;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends