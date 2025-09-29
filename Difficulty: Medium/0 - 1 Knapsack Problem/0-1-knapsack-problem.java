class Solution {
    static int[][] dp = new int[1001][1001];
    static int help(int w, int val[], int wt[],int i){
        if(i>=val.length)return 0;
        if(dp[i][w]!=-1)return dp[i][w];
        
        int take=0;
        if(w>=wt[i]) 
            take=help(w-wt[i],val,wt,i+1)+val[i];
        int nottake=help(w,val,wt,i+1);
        
        return dp[i][w]=Math.max(take,nottake);
    }
    static int knapsack(int W, int val[], int wt[]) {
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return help(W,val,wt,0);
    }
}
