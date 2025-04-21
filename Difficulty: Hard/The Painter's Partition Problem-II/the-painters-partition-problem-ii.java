//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean possible(int mid,int k,int []arr){
        int i=0;
        int s=0;
        int c=1;
        
        while(i<arr.length){
            if (arr[i] > mid) return false; 
            if (s + arr[i] > mid) {
                c++;
                s = 0;
            } 
            s += arr[i];
            i++;
        }
        return c<=k;
    }
    public static int minTime(int[] arr, int k) {
        // if (arr.length < k) return -1; 
        int l=0;
        int r=0;
        for(int i:arr){
            l = Math.max(l, i);
            r+=i;
        }
        int ans = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (possible(mid, k, arr)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
