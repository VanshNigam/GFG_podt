// User function Template for Java

class Solution {
    int help(int val[], int wt[], int capacity,int curr,int i,int dp[][]){
        if (i >= val.length || capacity == 0)
            return 0;
        if(dp[i][curr]!=-1)return dp[i][curr];
        
        int take=0;
        int nottake=0;
        
        if(wt[i]+curr<=capacity){
            take=val[i]+help(val,wt,capacity,curr+wt[i],i,dp);
        }
        nottake=help(val,wt,capacity,curr,i+1,dp);
        
        return dp[i][curr]=Math.max(take,nottake);
    }
    int knapSack(int val[], int wt[], int capacity) {
        // code here
        
        int dp[][]=new int[wt.length][capacity+1];
        for(int i[]:dp)Arrays.fill(i,-1);
        
        return help(val,wt,capacity,0,0,dp);
    }
}