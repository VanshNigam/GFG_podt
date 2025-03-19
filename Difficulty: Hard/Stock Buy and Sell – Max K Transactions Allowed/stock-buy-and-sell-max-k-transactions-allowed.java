//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int help(int arr[], int k, int i, int canBuy, int[][][] dp) {
        if (i == arr.length || k == 0) return 0;
        if (dp[i][k][canBuy] != -1) return dp[i][k][canBuy];

        int max = 0;
        if (canBuy == 1) {
            int buy = help(arr, k, i + 1, 0, dp) - arr[i]; // Buy stock
            int skip = help(arr, k, i + 1, 1, dp); // Skip buying
            max = Math.max(buy, skip);
        } else {
            int sell = help(arr, k - 1, i + 1, 1, dp) + arr[i]; // Sell stock
            int notSell = help(arr, k, i + 1, 0, dp); // Skip selling
            max = Math.max(sell, notSell);
        }

        return dp[i][k][canBuy] = max;
    }

    public int maxProfit(int prices[], int k) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        for (int[][] row : dp) {
            for (int[] col : row) Arrays.fill(col, -1);
        }
        return help(prices, k, 0, 1, dp);
    }
}
