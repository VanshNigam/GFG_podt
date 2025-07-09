class Solution {
  public:
    int sumSubMins(vector<int> &arr) {
        int n = arr.size();
        stack <int> s;
        vector <int> left(n), right(n);
        
        for(int i = 0; i < n; i++){
            while(!s.empty() && arr[s.top()] > arr[i]) s.pop();
            left[i] = (s.empty() ? -1 : s.top());
            s.push(i);
        }
        
        while(!s.empty()) s.pop();
        
        for(int j = n-1; j >= 0; j--){
            while(!s.empty() && arr[s.top()] >= arr[j]) s.pop();
            right[j] = (s.empty() ? n : s.top());
            s.push(j);
        }
        
        int ans = 0;
        for(int k = 0; k < n; k++)
            ans += (arr[k]) * (k - left[k]) * (right[k] - k);
        
        return ans;
    }
};