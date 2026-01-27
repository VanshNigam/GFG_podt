class Solution:
    def countSubset(self, arr, k):
        from collections import Counter
        
        n = len(arr)
        mid = n // 2
        
        left = arr[:mid]
        right = arr[mid:]
        
        def get_subset_sums(nums):
            sums = [0]
            for num in nums:
                sums += [num + s for s in sums]
            return sums
        
        left_sums = get_subset_sums(left)
        right_sums = get_subset_sums(right)
        
        right_count = Counter(right_sums)
        
        count = 0
        for s in left_sums:
            count += right_count[k - s]
        
        return count