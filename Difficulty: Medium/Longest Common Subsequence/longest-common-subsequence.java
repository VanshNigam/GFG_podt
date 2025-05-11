//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    int help(String s1, String s2,int i,int j,int dp[][]){
        if(i==s1.length())return 0;
        if(j==s2.length())return 0;
        if(dp[i][j]!=0)return dp[i][j];
        
        int match=0;
        if(s1.charAt(i)==s2.charAt(j))match=1+help(s1,s2,i+1,j+1,dp);
        int not_match=Math.max(help(s1,s2,i+1,j,dp),help(s1,s2,i,j+1,dp));
        
        return dp[i][j]=Math.max(match,not_match);
    }
    int lcs(String s1, String s2) {
        // code here
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        return help(s1,s2,0,0,dp);
    }
}