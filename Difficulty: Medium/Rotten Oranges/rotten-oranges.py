class Solution:
	def orangesRotting(self, mat):
		#Code here
        rq = []
        pos = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 2:
                    rq.append((i, j, 0))
        maxi = 0
        while rq:
            i, j, l = rq.pop(0)
            for dx, dy in pos:
                ni, nj = i + dx, j + dy
                if ni >= 0 and nj >= 0 and ni < len(mat) and nj < len(mat[0]) and mat[ni][nj] == 1:
                    maxi = max(maxi, l + 1)
                    rq.append((ni, nj, l + 1))
                    mat[ni][nj] = 2
                    
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 1:
                    return -1
                    
        return maxi
#{ 
 # Driver Code Starts
from queue import Queue

T = int(input())
for i in range(T):
    n = int(input())
    m = int(input())
    mat = []
    for _ in range(n):
        a = list(map(int, input().split()))
        mat.append(a)
    obj = Solution()
    ans = obj.orangesRotting(mat)
    print(ans)
    print("~")

# } Driver Code Ends