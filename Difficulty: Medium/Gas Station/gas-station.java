//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            ArrayList<Integer> array2 = new ArrayList<Integer>();

            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            line = read.readLine();
            tokens = line.split(" ");
            for (String token : tokens) {
                array2.add(Integer.parseInt(token));
            }

            // ArrayList<Integer> v = new ArrayList<Integer>();
            int[] gas = new int[array1.size()];
            int idx = 0;
            for (int i : array1) gas[idx++] = i;

            int[] cost = new int[array2.size()];
            idx = 0;
            for (int i : array2) cost[idx++] = i;

            int ans = new Solution().startStation(gas, cost);

            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        
        // Step 1: Check if total gas is enough to cover total cost
        for(int i = 0; i < n; ++i) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalCost > totalGas) return -1; // Not possible to complete the circuit
        
        int total = 0, ans = 0;
        
        // Step 2: Find the optimal starting station
        for(int i = 0; i < n; ++i) {
            total += (gas[i] - cost[i]); // Update current gas balance
            if(total < 0) { // If deficit, reset and try next station
                ans = (i + 1) % n; // Next station is the new candidate
                total = 0; // Reset gas balance
            }
        }
        
        return ans; // The correct starting index
    }
}