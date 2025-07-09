class Solution():
    def longestString(self, arr):
        arr_set = set(arr)
        ans = ""
        
        for word in arr:
            # Check if all prefixes exist
            is_valid = True
            for i in range(1, len(word) + 1):
                if word[:i] not in arr_set:
                    is_valid = False
                    break
            if is_valid:
                if len(word) > len(ans) or (len(word) == len(ans) and word < ans):
                    ans = word
        return ans