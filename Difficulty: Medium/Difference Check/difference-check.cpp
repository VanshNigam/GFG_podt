class Solution {
  public:
    int minDifference(vector<string> &arr) {
        int n=arr.size();
        vector<int>temp;
        for(auto&str:arr){
            int hr=((str[0]-'0')*10+(str[1]-'0'))*60*60;
            int minutes=((str[3]-'0')*10+(str[4]-'0'))*60;
            int second=((str[6]-'0')*10+(str[7]-'0'));
            int totalSec=hr+minutes+second;
            temp.push_back(totalSec);
        }
        sort(temp.begin(),temp.end());
        int minDiff=INT_MAX;
        for(int i=1;i<n;i++){
            minDiff=min(minDiff,temp[i]-temp[i-1]);
        }
        minDiff=min(minDiff,86400-(temp[n-1]-temp[0]));
        return minDiff;
    }
};