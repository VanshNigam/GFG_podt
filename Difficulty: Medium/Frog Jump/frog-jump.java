
class Solution {
    int minCost(int[] height) {
        // code here
        
        
       
       int n= height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, height, dp);
    }

    private int solve(int i, int[] height, int[] dp) {
        if (i == 0) return 0; // already at first stone
        if (dp[i] != -1) return dp[i];

        // jump from i-1
        int oneStep = solve(i - 1, height, dp) + Math.abs(height[i] - height[i - 1]);

        // jump from i-2
        int twoStep = Integer.MAX_VALUE;
        if (i > 1) {
            twoStep = solve(i - 2, height, dp) + Math.abs(height[i] - height[i - 2]);
        }

        return dp[i] = Math.min(oneStep, twoStep);
    }
}