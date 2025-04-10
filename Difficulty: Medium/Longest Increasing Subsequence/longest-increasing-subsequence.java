//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    int help(int arr[],int i,int prev_ind,int dp[][]){
        if(i==arr.length)return 0;
        if(dp[i][prev_ind+1]!=-1)return dp[i][prev_ind+1];
        
        int found=0;
        if(prev_ind==-1||arr[i]>arr[prev_ind])found=1+help(arr,i+1,i,dp);
        int not_found=help(arr,i+1,prev_ind,dp);
        
        return dp[i][prev_ind+1]=Math.max(found,not_found);
    }
    int lis(int arr[]) {
        int dp[][]=new int[arr.length][arr.length+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        return help(arr,0,-1,dp);
    }
}