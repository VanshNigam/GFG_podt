
class Solution {
    public int countPS(String s) {
        int n = s.length();
        // Initialize DP array with -1
        int[][] dp = new int[n][n];
        for (int[] row : dp) java.util.Arrays.fill(row, -1);
        // Call the recursive function
        return count(s, 0, n - 1, dp);
    }

    // Recursive function with memoization
    public int count(String s, int i, int j, int[][] dp) {
        // If i > j, return 0
        if (i > j) return 0;

        // If i == j, single char is a palindrome
        if (i == j) return 1;

        // If already computed
        if (dp[i][j] != -1) return dp[i][j];

        // If characters match
        if (s.charAt(i) == s.charAt(j))
            dp[i][j] = count(s, i + 1, j, dp) + 
                             count(s, i, j - 1, dp) + 1;
        else
            // Subtract overlapping part
            dp[i][j] = count(s, i + 1, j, dp) + count(s, i, j - 1, dp) -
                             count(s, i + 1, j - 1, dp);

        return dp[i][j];
    }
}