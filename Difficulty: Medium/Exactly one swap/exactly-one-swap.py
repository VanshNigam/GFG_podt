from collections import Counter
class Solution:
    def countStrings(self, s): 
        d=Counter(s)
        ans=0
        n=len(s)
        for i in d.values():
            if i>1:
                ans+=(i*(i-1))//2
        res=(n*(n-1))//2 - ans 
        if ans>0:
            res+=1
        return res