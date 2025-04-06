//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, 1); //min LIS =1 for all
        
        int preInd[] = new int[n];
        int ans = 1;
        int last=0;

        for (int i = 1; i < n; i++) {
            preInd[i]=i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && dp[i]<dp[prev]+1) {
                    
                    preInd[i]=prev;
                    dp[i] = 1 + dp[prev];
                }
            }
            if(ans<dp[i]){
                ans=dp[i];
                last=i;
            }
        }
        ArrayList<Integer>a=new ArrayList<>();
        while(last!=preInd[last]){
            a.add(0, nums[last]);
            last=preInd[last];
        }
        a.add(0, nums[last]);

        return a;
    }
}
