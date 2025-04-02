//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int rem) {
        // code here
        int n=val.size();
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for(int i=0;i<n;i++){
            double temp=(double)val.get(i)/wt.get(i);
            pq.add(new double[]{temp,(double)i});
        }
        
        double ans=0;
        while(!pq.isEmpty()){
            double temp[]=pq.poll();
            
            int i=(int)(temp[1]);
            //Base Case
            if(rem==0)return ans;
            
            if(rem>=wt.get(i)){
                rem-=wt.get(i);
                ans+=val.get(i);
                
                if(rem==0)return ans;
                
            }else if(rem<wt.get(i)){
                
                double avl = (double) wt.get(i) / rem; 
                ans += ((double) val.get(i) / avl); 
                return ans;

            }
        }
        return ans;
    }
}