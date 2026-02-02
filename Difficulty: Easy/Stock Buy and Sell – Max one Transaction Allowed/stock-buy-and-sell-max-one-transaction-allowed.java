

// User function Template for Java

class Solution {
    public int maxProfit(int prices[]) {
        int m=0,buy=Integer.MAX_VALUE;
        for(int i:prices){
            if(buy>i)buy=i;
            else m=Math.max(i-buy,m); }
        return m;
    }
}