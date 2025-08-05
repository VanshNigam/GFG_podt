class Solution {
  public:
    int romanToDecimal(string &s) {
        unordered_map<char,int> mp;
        mp['I']=1;
        mp['V']=5;
        mp['X']=10;
        mp['L']=50;
        mp['C']=100;
        mp['D']=500;
        mp['M']=1000;
        int amt=0;
        for(int i=0;i<s.length();i++){
            if(i+1<s.length() && mp[s[i]]<mp[s[i+1]]) amt-=mp[s[i]];
            else amt+=mp[s[i]];
        }
        return amt;
    }
};