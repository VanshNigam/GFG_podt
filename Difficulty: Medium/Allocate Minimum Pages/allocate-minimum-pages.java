//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

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
    public static int findPages(int[] arr, int k) {
        if (arr.length < k) return -1; 
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