//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    Boolean help(int arr[],int sum,int i,Boolean dp[][]){
        if(sum==0)return true;
        if(i==arr.length)return false;
        if(dp[i][sum]!=null)return dp[i][sum];
        
        boolean take=false;
        if(sum>=arr[i]) take=help(arr,sum-arr[i],i+1,dp);
        boolean not_take=help(arr,sum,i+1,dp);
        return dp[i][sum]=take||not_take;
    }

     Boolean isSubsetSum(int arr[], int sum) {
        // code here
        Boolean dp[][]=new Boolean[arr.length][sum+1];
        return help(arr,sum,0,dp);
    }
}