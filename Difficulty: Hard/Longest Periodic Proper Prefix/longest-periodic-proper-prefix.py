class Solution:
    def getLongestPrefix(self, s):
        n = len(s)
        if n == 0:
            return -1
        
        max_len = -1
        for len_candidate in range(n-1, 0, -1):
            prefix = s[:len_candidate]
            repeated = prefix * ((n // len_candidate) + 1)
            if repeated.startswith(s):
                max_len = len_candidate
                break
        
        return max_len