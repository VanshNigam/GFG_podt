//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int sol( int arr[] , int i ,int[] dp){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int peek = arr[i]+sol(arr,i+2,dp);
        int notPeek = sol(arr,i+1,dp);
        return  dp[i] = Math.max(peek,notPeek);
    }
    int maxValue(int[] arr) {
        int n = arr.length;
        if(n==0) return 0;
        if(n==1) return arr[0];
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
        int max1 = sol(Arrays.copyOfRange(arr, 0, n - 1), 0, dp1);
        int max2 = sol(Arrays.copyOfRange(arr, 1, n), 0, dp2);
        return Math.max(max1, max2);
    }
}