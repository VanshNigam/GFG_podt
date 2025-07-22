class Solution {
    public int subarraySum(int[] arr) {
        int n = arr.length;
        long total = 0;
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * (i + 1) * (n - i);
            total += contribution;
        }
        return (int) total;
    }
}