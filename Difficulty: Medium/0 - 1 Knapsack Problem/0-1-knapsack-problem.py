#User function Template for python3

class Solution:
    # Function to return max value that can be put in knapsack of capacity.
    def knapsack(self, W, val, wt):
        n=len(val)
        dp = [[0] * (W + 1) for _ in range(n + 1)]

        # Fill the DP table iteratively
        for i in range(1, n + 1):
            for w in range(1, W + 1):
                # If the current item's weight is less than or equal to the current capacity, we can choose to include it or exclude it
                if wt[i - 1] <= w:
                    # Decide whether to include the current item or not and choose the option that gives maximum value
                    dp[i][w] = max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w])
                else:
                    # If the current item's weight is more than the current capacity, we cannot include it
                    dp[i][w] = dp[i - 1][w]

        # The maximum value that can be achieved with a knapsack of capacity W using all items is stored at dp[n][W]
        return dp[n][W]


#{ 
 # Driver Code Starts
if __name__ == '__main__':
    test_cases = int(input())
    for _ in range(test_cases):
        capacity = int(input())
        values = list(map(int, input().strip().split()))
        weights = list(map(int, input().strip().split()))
        ob = Solution()
        print(ob.knapsack(capacity, values, weights))
        print("~")
# } Driver Code Ends