//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            ArrayList<Integer> ans = obj.getLIS(arr);
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
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        
        int prevInd[]=new int[n];
        
        int maxI=0;
        int max=0;
        for(int i=0;i<n;i++){
            prevInd[i]=i;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    if(dp[i]>max){
                        max=dp[i];
                        maxI=i;
                    }
                    prevInd[i]=j;
                }
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(maxI !=prevInd[maxI]){
            ans.add(0,arr[maxI]);
            maxI=prevInd[maxI];
        }
        ans.add(0,arr[maxI]);
        return ans;
    }
}
