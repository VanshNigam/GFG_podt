#User function Template for python3
class Solution:
    def countWays(self, n):
        # code here
        if n == 0 or n==1:
            return 1
        arr=[0]*(n+1)
        arr[0]=1
        arr[1]=1
        for i in range(2,n+1):
            arr[i] = arr[i-1] + arr[i-2]
        return arr[-1]



#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

sys.setrecursionlimit(10**6)

# Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        m = int(input())
        ob = Solution()
        print(ob.countWays(m))

        print("~")

# } Driver Code Ends