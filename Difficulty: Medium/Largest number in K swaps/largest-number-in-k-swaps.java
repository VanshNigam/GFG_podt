//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    String max = "";

    public String findMaximumNum(String s, int k) {
        max = s;
        char[] arr = s.toCharArray();
        solve(arr, k, 0);
        return max;
    }

    private void solve(char[] arr, int k, int index) {
        if (k == 0 || index >= arr.length) return;

        int n = arr.length;
        char maxChar = arr[index];

        // Find the maximum digit in the suffix
        for (int i = index + 1; i < n; i++) {
            if (arr[i] > maxChar) {
                maxChar = arr[i];
            }
        }

        // If no better digit found, do not reduce k
        if (maxChar != arr[index]) k--;

        for (int i = n - 1; i >= index; i--) {
            if (arr[i] == maxChar) {
                swap(arr, index, i);

                String curr = new String(arr);
                if (curr.compareTo(max) > 0) {
                    max = curr;
                }

                solve(arr, k, index + 1);

                swap(arr, index, i); // backtrack
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}