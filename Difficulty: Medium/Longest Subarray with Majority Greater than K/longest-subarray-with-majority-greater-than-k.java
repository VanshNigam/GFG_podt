//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
        Map<Integer,Integer>mp=new HashMap<>();

        mp.put(0,-1);
        int prefixsum=0;
        int max=0;
        
        for(int i=0;i<arr.length;i++){
            prefixsum+=(arr[i]>k)?1:-1;
            
            if(prefixsum > 0)max=i+1;
            
            if(mp.containsKey(prefixsum-1)){
                max=Math.max(max,i-mp.get(prefixsum-1));
            }
            if(!mp.containsKey(prefixsum))mp.put(prefixsum,i);
        }
        return max;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends