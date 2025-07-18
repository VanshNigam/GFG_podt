class Solution {
  public:
    int vowelCount(string& s) {
        unordered_map<char,int> mpp;
        for(auto& c:s) mpp[c]++;
        int ans=0;
        int mul=1, prod=0;
        if(mpp['a']) {prod++; mul*=mpp['a'];}
        if(mpp['e']) {prod++; mul*=mpp['e'];}
        if(mpp['i']) {prod++; mul*=mpp['i'];}
        if(mpp['o']) {prod++; mul*=mpp['o'];}
        if(mpp['u']) {prod++; mul*=mpp['u'];}
        int temp=prod;
        for(int i=2;i<temp;i++){
            prod*=i;
        }
        return prod*mul;
    }
};