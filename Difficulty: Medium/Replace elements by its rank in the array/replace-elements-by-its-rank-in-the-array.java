//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
     PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
    //  Map<Integer,Integer>mp=new HashMap<>();
     
     for(int i=0;i<N;i++){
         pq.add(new int[]{arr[i],i});
     }
     
     int k=1;
     int prev=-1;
     while(!pq.isEmpty()){
         int []a=pq.poll();
         if(prev==-1)prev=a[0];
         if (prev!=a[0])k++;
         prev=a[0];
         arr[a[1]]=k;
     }
     return arr;
  }
}
     