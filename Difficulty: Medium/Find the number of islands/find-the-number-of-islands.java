//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public void dfs(char[][] grid,int dp[][],int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i>-1 && i<n && j>-1 && j<m && grid[i][j]=='L'){
            if(dp[i][j]==0)return;
            dp[i][j]=0;
            grid[i][j]='W';
            
            dfs(grid,dp,i-1,j-1);//up left
            dfs(grid,dp,i-1,j);//up 
            dfs(grid,dp,i-1,j+1);//up right
            
            dfs(grid,dp,i,j-1);//left
            dfs(grid,dp,i,j+1);//right
            
            dfs(grid,dp,i+1,j-1);//down left
            dfs(grid,dp,i+1,j);//down 
            dfs(grid,dp,i+1,j+1);//down right
            
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        Map<Integer,Boolean>mp=new HashMap<>();
        
        int dp[][]=new int[n][m];
        for(int i[]:dp)Arrays.fill(i,-1);
        
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='L'){
                    dfs(grid,dp,i,j);
                    c++;
                }
            }
        }
        return c;
    }
}