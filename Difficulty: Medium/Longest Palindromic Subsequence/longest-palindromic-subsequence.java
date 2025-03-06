//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        int dp[][] = new int[S.length()+1][S.length()+1];
        String rev = "";
        for(int i=0; i<S.length(); i++){
            rev = S.charAt(i) + rev;
        }
        for(int ind1 = 1; ind1 <=S.length(); ind1++){
            for(int ind2 = 1; ind2<=rev.length(); ind2++){
                if(S.charAt(ind1-1) == rev.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        return dp[S.length()][S.length()];
    }
}


