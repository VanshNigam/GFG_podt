class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + arr[i];
        }

        // We need min pref[t] for t in [j - b, j - a]
        // Use a deque to store candidate t indices with increasing pref[]
        java.util.ArrayDeque<Integer> dq = new java.util.ArrayDeque<>();

        long best = Long.MIN_VALUE;

        for (int j = 1; j <= n; j++) {
            // Add new candidate t = j - a into the deque
            int tAdd = j - a;
            if (tAdd >= 0) {
                // Maintain monotonicity: keep pref[t] increasing in deque
                while (!dq.isEmpty() && pref[dq.peekLast()] >= pref[tAdd]) {
                    dq.pollLast();
                }
                dq.addLast(tAdd);
            }

            // Remove indices that are out of window: t < j - b
            int outIndex = j - b - 1;
            while (!dq.isEmpty() && dq.peekFirst() <= outIndex) {
                dq.pollFirst();
            }

            if (!dq.isEmpty()) {
                long candidate = pref[j] - pref[dq.peekFirst()];
                if (candidate > best) best = candidate;
            }
        }

        // If best remains very negative due to constraints, handle (though with valid inputs there is always at least one subarray)
        return (int) best;
    }

    // Optional main for quick local testing
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr1 = {4, 5, -1, -2, 6};
        int a1 = 2, b1 = 4;
        System.out.println(s.maxSubarrSum(arr1, a1, b1)); // 9

        int[] arr2 = {-1, 3, -1, -2, 5, 3, -5, 2, 2};
        int a2 = 3, b2 = 5;
        System.out.println(s.maxSubarrSum(arr2, a2, b2)); // 8
    }
}