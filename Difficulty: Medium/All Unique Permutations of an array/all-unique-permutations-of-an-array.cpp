class Solution {
  public:
    void solve(vector<int> &arr, int fix, set<vector<int>> &per)
    {
        if(fix == arr.size()){
            per.insert(arr);
            return;
        }
        for(int i = fix;i<arr.size();i++){
            swap(arr[fix], arr[i]);
            solve(arr,fix+1,per);
            swap(arr[fix], arr[i]);
        }
        return;
    }
    vector<vector<int>> uniquePerms(vector<int>& arr) {
        set<vector<int>> per;
        solve(arr, 0, per);
        vector<vector<int>> res(per.begin(), per.end());
        return res;
    }
};