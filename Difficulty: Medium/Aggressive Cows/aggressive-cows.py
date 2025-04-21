class Solution:
    def place(self,mid,arr,k):
        c=0
        sum=0
        prev=-mid
        
        for i in arr:
            if(i-prev>=mid):
                prev=i
                c+=1

        return c>=k
    def aggressiveCows(self, arr, k):
        # your code here
        arr.sort()
        l=0
        r=max(arr)
        ans=0
        
        while(l<=r):
            mid=(int)((l+r)/2)
            
            if(self.place(mid,arr,k)):
                ans=mid
                l=mid+1
            else:
                r=mid-1
                
        return r
        



#{ 
 # Driver Code Starts
#Initial Template for Python 3
import bisect
#Main
if __name__ == '__main__':
    t = int(input())
    while t:
        t -= 1
        A = [int(x) for x in input().strip().split()]
        nd = [int(x) for x in input().strip().split()]
        D = nd[0]
        ob = Solution()
        ans = ob.aggressiveCows(A, D)
        print(ans)
        print("~")
# } Driver Code Ends