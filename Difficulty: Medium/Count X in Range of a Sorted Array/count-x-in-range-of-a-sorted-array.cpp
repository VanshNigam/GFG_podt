class Solution {
  public:
    vector<int> countXInRange(vector<int>& arr, vector<vector<int>>& q) {
        // code here
            vector<int> ans;
            int n = q.size();
            
            for( int i=0; i<n; i++){
                auto lo = lower_bound( arr.begin()+q[i][0] , arr.begin() + q[i][1]+1, q[i][2]);
                auto hi = upper_bound( arr.begin()+q[i][0] , arr.begin() + q[i][1]+1, q[i][2]);
                ans.push_back(hi-lo);
            }
            
            return ans;
    }
};