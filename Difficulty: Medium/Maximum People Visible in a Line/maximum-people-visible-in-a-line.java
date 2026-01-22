class Solution {
    public int maxPeople(int[] arr) {
        int n = arr.length;
        int[] leftGE = new int[n];
        int[] rightGE = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Nearest Greater-or-Equal on LEFT
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            leftGE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Nearest Greater-or-Equal on RIGHT
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            rightGE[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int visible = rightGE[i] - leftGE[i] - 1;
            ans = Math.max(ans, visible);
        }

        return ans;
    }
}