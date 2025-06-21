
class Solution {
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
    }
    public ArrayList<Integer> largestSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        reverse(nums); // Sort in descending order for lex greatest subset

        int[] dp = new int[n];
        int[] hash = new int[n];
        int max = 1, last_index = 0;
        Arrays.fill(dp, 1);

        for (int ind = 0; ind < n; ind++) {
            hash[ind] = ind;
            for (int prev = 0; prev < ind; prev++) {
                if (nums[prev] % nums[ind] == 0 && dp[prev] + 1 > dp[ind]) {
                    dp[ind] = dp[prev] + 1;
                    hash[ind] = prev;
                }
            }
            if (dp[ind] > max) {
                max = dp[ind];
                last_index = ind;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[last_index]);
        while (hash[last_index] != last_index) {
            last_index = hash[last_index];
            res.add(nums[last_index]);
        }
        Collections.sort(res); // Final output in ascending order
        return res;
    }
}

