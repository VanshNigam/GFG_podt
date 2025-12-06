class Solution {
    
    public int maximumAmount(int arr[]) {
        int n = arr.length;
        Integer[][] dp = new Integer[n][n];
        return solve(arr, 0, arr.length-1, dp);
    }
    
    private int solve(int[] arr, int f, int l, Integer[][] dp) {
        
        if(f>l) return 0;
        if(dp[f][l] != null) return dp[f][l];
        int a = arr[f]+Math.min(solve(arr, f+2, l, dp), solve(arr, f+1, l-1, dp));
        int b = arr[l]+Math.min(solve(arr, f, l-2, dp), solve(arr, f+1, l-1, dp));
        return dp[f][l] = Math.max(a, b);
    }
}