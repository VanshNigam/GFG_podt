

// User function Template for Java

class Solution {
    // k is the maximum number of zeros allowed to flip
    public int maxOnes(int arr[], int k) {
        int res = 0;
        int start = 0, end = 0;
        int cnt = 0;

        while (end < arr.length) {
            if (arr[end] == 0)
                cnt++;
            while (cnt > k) {
                if (arr[start] == 0)
                    cnt--;
                start++;
            }
            res = Math.max(res, (end - start + 1));
            end++;
        }

        return res;
    }
}