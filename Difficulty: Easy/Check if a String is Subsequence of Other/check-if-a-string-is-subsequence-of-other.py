
class Solution:
    def isSubSeq(self, A, B):
        # Pointers for iterating through both strings
        ptr_A = 0
        ptr_B = 0
        
        # Iterate through both strings until we reach the end of either string
        while ptr_A < len(A) and ptr_B < len(B):
            # If characters match, move pointer in string A
            if A[ptr_A] == B[ptr_B]:
                ptr_A += 1
            # Move pointer in string B regardless of match
            ptr_B += 1
        
        # If we reached the end of string A, it is a subsequence of B
        return ptr_A == len(A)
