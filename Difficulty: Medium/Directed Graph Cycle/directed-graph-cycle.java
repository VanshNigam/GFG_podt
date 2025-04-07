//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public static boolean topoSort(Map<Integer,Boolean>currPath,Map<Integer,Boolean>vis,int i,ArrayList<ArrayList<Integer>>adj){
        vis.put(i,true);
        currPath.put(i,true);
        
        for(int neigh:adj.get(i)){
            if(!vis.containsKey(neigh)){
                 if(topoSort(currPath,vis,neigh,adj))
                        return true;
            }
            else if(currPath.containsKey(neigh))
                return true;
        }
        currPath.remove(i);
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i[]:edges){
            ArrayList<Integer>temp=adj.get(i[0]);
            temp.add(i[1]);
        }
        
        Map<Integer,Boolean>vis=new HashMap<>();
        Map<Integer,Boolean>currPath=new HashMap<>();
        
        for(int i=0;i<V;i++){
            if(!vis.containsKey(i))
                if(topoSort(currPath,vis,i,adj))
                    return true;
        }
        return false;
    }
}