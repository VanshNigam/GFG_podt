class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        boolean vis[]=new boolean[V];
        
        int sum=0;
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for (int i = 0; i < V; i++)
            arr.add(new ArrayList<>());

        for (int i[] : edges) {
            arr.get(i[0]).add(new int[] { i[1], i[2] });
            arr.get(i[1]).add(new int[] { i[0], i[2] });
        }

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0, 0}); // {weight, node}

        while(!pq.isEmpty()){
            int pop[]=pq.poll();
            int wt=pop[0];
            int x=pop[1];
            
            if(vis[x])continue;
            vis[x]=true;
            sum+=wt;
            
            for(int neigh[]:arr.get(x)){
                if(vis[neigh[0]])continue;
                pq.add(new int[]{neigh[1],neigh[0]});
            }
        }
        return sum;
    }
}
