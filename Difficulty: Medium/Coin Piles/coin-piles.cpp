class Solution {
  public:
    int minimumCoins(vector<int>& A, int k) {
        int n = A.size();
        sort(A.begin(), A.end());

        vector<int> prefixsum(n, 0);
        prefixsum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixsum[i] = prefixsum[i - 1] + A[i];
        }

        int mini = INT_MAX;
        for (int i = 0; i < n; i++) {
            int index = lower_bound(A.begin() + i, A.end(), A[i] + k) - A.begin();

            int leftSum = (i > 0) ? prefixsum[i - 1] : 0;
            int rightSum = (index < n) ? (prefixsum[n - 1] - ((index > 0) ? prefixsum[index - 1] : 0)) : 0;
            int discount = (n - index) * (A[i] + k);

            mini = min(mini, leftSum + rightSum - discount);
        }

        return mini;
    }
};
