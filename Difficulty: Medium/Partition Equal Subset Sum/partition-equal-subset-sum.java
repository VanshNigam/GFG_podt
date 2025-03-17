//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean help(int arr[],int target,Boolean dp[][],int i){
        if(i==arr.length)return false;
        if(target==0)return true;
        if(dp[i][target]!=null)return dp[i][target];
        
        boolean take=false;
        if(arr[i]<=target)take=help(arr,target-arr[i],dp,i+1);
        boolean not_take=help(arr,target,dp,i+1);
        
        return dp[i][target]=take||not_take;
    }
    boolean equalPartition(int arr[]) {
        // code here
        int sum=0;
        for(int i:arr)sum+=i;
        
        if(sum%2!=0)return false;
        
        int target=sum/2;
        Boolean dp[][]=new Boolean[arr.length][target+1];
        return help(arr,target,dp,0);
    }
}