// User function Template for Java

class Solution {
    public static boolean helper(int arr[], int n, int sum, int i ,Boolean dp[][]) {
        if (i == n) {
            // If we've reached the end of the array, check if the current sum is zero
            return (sum == 0);
        }
        if( dp[i][sum]!=null)return  dp[i][sum];

        boolean include = (sum - arr[i] >= 0) ? helper(arr, n, sum - arr[i], i + 1, dp) : false;
        boolean exclude = helper(arr, n, sum, i + 1 ,dp);
        return  dp[i][sum] = include || exclude;
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int k) {
        // code here
        int n=arr.length;
        Boolean dp[][]=new Boolean[n][k+1];

        return helper(arr, n, k, 0 ,dp);
    }
}
