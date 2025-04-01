//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<Integer> ans=new ArrayList<> ();
    Map<Integer,Integer>mp=new HashMap<>();
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj,int i){
        mp.put(i,1);
        ans.add(i);
        
        for(int neigh:adj.get(i)){
            if(!mp.containsKey(neigh))
                dfs(adj,neigh);
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        for(int i=0;i<adj.size();i++){
            if(!mp.containsKey(i)){
                dfs(adj,i);
            }
        }
        return ans;
    }
}