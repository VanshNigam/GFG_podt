class Solution:
 def minDeletions(self,s):
    n=len(s)
    dp=[[0]*(n+1) for _ in range(2)]
    for i in range(1,n+1):
        for j in range(1,n+1):
            if s[i-1]==s[-j]:
                dp[1][j]=1+dp[0][j-1]
            else:
                dp[1][j]=max(dp[1][j-1],dp[0][j])
        dp[0]=dp[1].copy()
    return n-dp[1][n]