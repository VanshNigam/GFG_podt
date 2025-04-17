//{ Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int[] a = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        
        for(int i:arr)pq.add(i);
        int ans=0;
        
        while(!pq.isEmpty()){
            int a=pq.poll();
            
            if(pq.isEmpty()){
                return ans;
            }
            
            int b=pq.poll();
            ans+=(a+b);
            
            pq.add(a+b);
        }
        return ans;
    }
}