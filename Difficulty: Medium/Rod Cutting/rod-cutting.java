
class Solution {
    int help(int val[], int capacity,int i,int dp[][]){
        if (i == val.length || capacity == 0)
            return 0;
        if(dp[i][capacity]!=-1)return dp[i][capacity];
        
        int take=0;
        int nottake=0;
        
        if(i+1<=capacity){
            take=val[i]+help(val,capacity-(i+1),i,dp);
        }
        nottake=help(val,capacity,i+1,dp);
        
        return dp[i][capacity]=Math.max(take,nottake);
    }
    public int cutRod(int[] price) {
        // code here
        
        int dp[][]=new int[price.length][price.length+1];
        for(int i[]:dp)Arrays.fill(i,-1);
        
        return help(price,price.length,0,dp);
    }
}