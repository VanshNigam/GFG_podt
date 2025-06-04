class Solution {
    String a,b,c;
    int l,m,n;
    public int help(int i,int j,int k,int dp[][][]){
        if(i==l || j==m ||k==n){
            return 0;
        }
        if(dp[i][j][k]!=-1)return dp[i][j][k];
        if(a.charAt(i)==b.charAt(j) && a.charAt(i)==c.charAt(k)){
            return dp[i][j][k]=1+help(i+1,j+1,k+1,dp);
        }
        return dp[i][j][k]=Math.max(
                    help(i+1, j, k,dp),
                    Math.max(
                        help(i, j+1, k,dp),
                        Math.max(
                            help(i, j, k+1,dp),
                            Math.max(
                                help(i+1, j+1, k,dp),
                                Math.max(
                                    help(i+1, j, k+1,dp),
                                    help(i, j+1, k+1,dp)
                                )
                            )
                        )
                    )
                );
    }

    int lcsOf3(String s1, String s2, String s3) {
        // code here
        a=s1;
        b=s2;
        c=s3;
        l = s1.length();
        m = s2.length();
        n = s3.length();
        int dp[][][]=new int[l+1][m+1][n+1];
        for(int i=0;i<l;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        return help(0,0,0,dp);
    }
}