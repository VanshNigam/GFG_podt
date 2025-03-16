//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        if (arr.length == 1) return 0; // already at the last index
        if (arr[0] == 0) return -1; // cannot move forward from the start

        int currFuel = arr[0];
        int MaxFuel = arr[0];
        int jumps = 1; // we will need at least one jump
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps; // reached the last index

            currFuel--;
            MaxFuel = Math.max(MaxFuel - 1, arr[i]);

            if (currFuel == 0) {
                jumps++;
                if (MaxFuel <= 0) return -1; // cannot move forward
                currFuel = MaxFuel;
            }
        }
        return jumps;
    }
}