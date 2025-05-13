//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder curr = new StringBuilder();
        String prev = countAndSay(n - 1);
        int count = 0;

        for (int i = 0; i < prev.length(); i++) {
            count++;
            if (i == prev.length() - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                curr.append(count).append(prev.charAt(i));
                count = 0;
            }
        }

        return curr.toString();
    }
}
