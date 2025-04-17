//{ Driver Code Starts
// Initial Template for Java

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
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    static List<Integer> maxCombinations(int N, int k, int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = N - 1; i >= 0; i--) {
            pq.offer(new int[]{A[N - 1] + B[i], N - 1, i});
        }

        List<Integer> ans = new ArrayList<>();
        
        while (k > 0) {
            int[] curr = pq.poll();
            ans.add(curr[0]);

            if (curr[1] > 0) {
                pq.offer(new int[]{A[curr[1] - 1] + B[curr[2]], curr[1] - 1, curr[2]});
            }
            k--;
        }
        
        return ans;
    }
}

