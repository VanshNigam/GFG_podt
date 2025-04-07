//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    public static void topoSort(Stack<Integer>st,Map<Integer,Boolean>vis,int i,ArrayList<ArrayList<Integer>>adj){
        vis.put(i,true);
        
        for(int neigh:adj.get(i)){
            if(!vis.containsKey(neigh))
                topoSort(st,vis,neigh,adj);
        }
        st.push(i);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i[]:edges){
            ArrayList<Integer>temp=adj.get(i[0]);
            temp.add(i[1]);
        }
        
        Stack<Integer>st=new Stack<>();
        Map<Integer,Boolean>vis=new HashMap<>();
        
        for(int i=0;i<V;i++){
            if(!vis.containsKey(i))
                topoSort(st,vis,i,adj);
        }
        
        ArrayList<Integer>ans=new ArrayList<>();
        while(!st.isEmpty()){
           ans.add(st.pop());
        }
        return ans;
    }
}