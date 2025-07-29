class Solution:
    def isBuzz(self, n):
        return n % 7 == 0 or str(n).endswith('7')
