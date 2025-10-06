class Solution {
public:
    int lengthOfLongestAP(vector<int>& arr) {
        int n = arr.size();
        if(n <= 2) return n;
        
        vector<unordered_map<int,int>> dp(n);
        int ans = 2; // min length of AP is 2
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff = arr[i] - arr[j];
                int len = 2;
                if(dp[j].count(diff)) len = dp[j][diff] + 1;
                dp[i][diff] = len;
                ans = max(ans, len);
            }
        }
        
        return ans;
    }
};
