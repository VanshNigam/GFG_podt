class Solution {
  public:
    int substrWithVowels(string &s1, string &s2) {
        // code here
        set<char>st;
        unordered_map<int,int>mpp;
        for(char c: s1){
            st.insert(c);
        }
        int l = 0;
        int r = 0;        //a->1
        int n = s2.size();
        int k = s1.size();
        int mini = INT_MAX;
        while(r < n){
            if(st.count(s2[r])){
                mpp[s2[r]]++;
            }
            //shrink
            while(mpp.size()>=k){
                if(st.count(s2[l])){
                    mpp[s2[l]]--;
                    if(mpp[s2[l]]==0){
                        mpp.erase(s2[l]);
                    }
                }
                mini = min(mini,r-l+1);
                l++;
            }
            r++;
            
        }
        return mini==INT_MAX? -1:mini;
    }
};