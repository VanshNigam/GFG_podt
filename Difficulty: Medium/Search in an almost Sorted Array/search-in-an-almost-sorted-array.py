#{ 
 # Driver Code Starts

# } Driver Code Ends

#User function Template for python3
class Solution:
    def findTarget(self, arr, target):
        if target not in arr:
            return -1
        return arr.index(target)    
        # code herev


#{ 
 # Driver Code Starts.

if __name__ == "__main__":
    t = int(input())  # Number of test cases

    for _ in range(t):
        arr = list(map(int, input().strip().split()))  # Read the array
        target = int(input().strip())  # Read the target

        sln = Solution()
        ans = sln.findTarget(arr, target)
        print(ans)
        print("~")
# } Driver Code Ends