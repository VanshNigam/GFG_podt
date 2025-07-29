class Solution:
    def checkSpy(self, n):

        digits = [int(d) for d in str(n)]
        return sum(digits) == eval('*'.join(str(d) for d in digits))
