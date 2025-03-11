//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int[] dp = new int[n+1];
        dp[n] = 0;
        
        for(int i = n-1; i>=0; i--) {
            int min = Integer.MAX_VALUE;
            
            for(int j = 1; j <= 2 && i+j<dp.length; j++) {
                min = Math.min(dp[i+j], min);
            }
            
            dp[i] = min + cost[i];
        }
        
        return dp[0] < dp[1] ? dp[0] : dp[1];
    }
};