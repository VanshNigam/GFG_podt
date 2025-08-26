

class Solution {
    public int helper(int arr[], int n, int sum, int i ,int dp[][]) {
        if (i == n) {
            // If we've reached the end of the array, check if the current sum is zero
            return (sum == 0) ? 1 : 0;
        }
        if( dp[i][sum]!=-1)return  dp[i][sum];

        int include = (sum - arr[i] >= 0) ? helper(arr, n, sum - arr[i], i + 1, dp) : 0;
        int exclude = helper(arr, n, sum, i + 1 ,dp);
        return  dp[i][sum] = include + exclude;
    }

    public int perfectSum(int arr[], int sum) {
        int n=arr.length;
        int dp[][]=new int[n][sum+1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        return helper(arr, n, sum, 0 ,dp);
    }
}
