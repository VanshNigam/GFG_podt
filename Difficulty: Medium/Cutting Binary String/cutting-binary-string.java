class Solution {
    public int help(int i,String s,HashSet<Integer>st,int dp[]){
        if(i>=s.length())return 0;
        if(dp[i]!=-1)return dp[i];
        
        int ans=s.length()+1;
        int num=0;
        
        for(int j=i;j<s.length();j++){
            num=num*2+s.charAt(j)-'0';
            
            if(s.charAt(i)!='0' && st.contains(num)){
                ans=Math.min(ans,1+help(j+1,s,st,dp));
            }
        }
        return dp[i]=ans;
    }
    public int cuts(String s) {
        // code here
        if(s.charAt(0)=='0')return -1;
        
        HashSet<Integer>st=new HashSet<>();
        for(int i=1;i<1000000000;i*=5){
            st.add(i);
        }
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        
        int ans=help(0,s,st,dp);
        return ans>s.length()?-1:ans;
    }
}
