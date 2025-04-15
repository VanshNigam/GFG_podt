//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int l=0;
        int r=0;
        
        int n=s.length(),max=0;
        Map<Character,Integer>mp=new HashMap<>();
        
        while(l<n && r<n){
            char ch=s.charAt(l);
            
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            if(mp.size()>k){
                int x=mp.get(s.charAt(r));
                if(x>1)mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)-1);
                else mp.remove(s.charAt(r));
                r++;
            }
            else if(mp.size()==k){
                max=Math.max(l-r+1,max);
            }
            l++;
        }
        return max==0?-1:max;
    }
}