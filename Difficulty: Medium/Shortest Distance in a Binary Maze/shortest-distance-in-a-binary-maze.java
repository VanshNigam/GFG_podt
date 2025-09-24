// User function Template for Java

class Solution {
    
    int shortestPath(int[][] grid, int[] s, int[] des) {
        int n = grid.length, m = grid[0].length;
        int dir[][]=new int[][]{{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};
        
        Queue<int[]>q=new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        q.add(new int[]{0,s[0],s[1]});
        vis[s[0]][s[1]]=true;
        
        while(!q.isEmpty()){
            int pop[] = q.poll();
            if(pop[1]==des[0] && pop[2]==des[1]) return pop[0];
            
            for(int neigh[] : dir){
                int ni = pop[1] + neigh[0];
                int nj = pop[2] + neigh[1];
                int wt = pop[0] + 1;
        
                if(ni<0 || nj<0 || ni>=n || nj>=m || vis[ni][nj] || grid[ni][nj]==0) continue;
        
                vis[ni][nj] = true;
                q.add(new int[]{wt, ni, nj});
            }
        }

        return -1;
    }
}
