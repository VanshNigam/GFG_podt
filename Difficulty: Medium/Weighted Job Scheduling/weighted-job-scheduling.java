class Solution {
    private int findLastNonOverlappingJob(int[][] jobs, int currentIndex) {
        int low = 0, high = currentIndex - 1;
        int currentStartTime = jobs[currentIndex][0];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][1] <= currentStartTime) {
                if (jobs[mid + 1][1] <= currentStartTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int maxProfit(int[][] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = jobs[0][2]; 
        for (int i = 1; i < n; i++) {
            int profitExcludingCurrent = dp[i - 1];
            int profitIncludingCurrent = jobs[i][2];
            int lastNonOverlappingJobIndex = findLastNonOverlappingJob(jobs, i);
            if (lastNonOverlappingJobIndex != -1) {
                profitIncludingCurrent += dp[lastNonOverlappingJobIndex];
            }
            dp[i] = Math.max(profitExcludingCurrent, profitIncludingCurrent);
        }
        return dp[n - 1];
    }
}

