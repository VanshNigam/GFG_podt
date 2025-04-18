//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        int s=0;
        int e=m;

        while(s<=e){
            int mid=s+(e-s)/2;
            long sqt=1;
            for(int i=0;i<n;i++) sqt*=mid;
            
            if(sqt==m)return mid;
            else if(sqt<m)
                s=mid+1;
            else
                e=mid-1;
            
        }
        return -1;
    }
}