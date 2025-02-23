# User function Template for python3

class Solution:
    # Function to find the next greater element for each element of the array.
    def nextLargerElement(self, arr):
        ans=[-1]*len(arr)
        st=[]
        
        for i in range(len(arr)):
            # print(ans,st)
            while st and arr[st[-1]]<arr[i]:# when a big number greater than stack 
            # top is come than pop the stack till top of stack is less
                ans[st.pop()]=arr[i]
             
            st.append(i)
        return ans    





#{ 
 # Driver Code Starts
# Initial Template for Python 3

t = int(input())  # number of test cases
for _ in range(t):
    arr = list(map(int, input().split()))  # input array
    s = Solution().nextLargerElement(arr)  # find the next greater elements

    # Output formatting
    if s:
        print(" ".join(map(str, s)))  # Print next greater elements
    else:
        print("[]")  # Print empty list if no next greater element is found
    print("~")
# } Driver Code Ends