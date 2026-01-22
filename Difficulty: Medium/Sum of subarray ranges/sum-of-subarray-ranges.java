class Solution {
    public int subarrayRanges(int[] arr) {
        int n = arr.length;
        long maxSum = 0, minSum = 0;

        // ---------- MINIMUM CONTRIBUTION ----------
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            leftMin[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            rightMin[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long count = (long)(i - leftMin[i]) * (rightMin[i] - i);
            minSum += arr[i] * count;
        }

        // ---------- MAXIMUM CONTRIBUTION ----------
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        st.clear();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            leftMax[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            rightMax[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long count = (long)(i - leftMax[i]) * (rightMax[i] - i);
            maxSum += arr[i] * count;
        }

        return (int)(maxSum - minSum);
    }
}
