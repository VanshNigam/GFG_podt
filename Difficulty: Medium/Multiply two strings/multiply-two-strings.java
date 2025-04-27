//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String multiplyStrings(String s1, String s2) {
        // Edge case: if either number is "0"
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        
        // Convert the strings to BigInteger
        BigInteger num1 = new BigInteger(s1);
        BigInteger num2 = new BigInteger(s2);
        
        // Multiply the BigIntegers
        BigInteger result = num1.multiply(num2);
        
        // Return the result as a string
        return result.toString();
    }
}