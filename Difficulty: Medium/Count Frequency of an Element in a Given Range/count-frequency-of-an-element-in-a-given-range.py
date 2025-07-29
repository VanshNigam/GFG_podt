from collections import defaultdict
import bisect

class Solution:
    def freqInRange(self, arr, queries):
        # Preprocess: Map value to list of indices
        positions = defaultdict(list)
        for idx, val in enumerate(arr):
            positions[val].append(idx)

        result = []
        for l, r, x in queries:
            idx_list = positions.get(x, [])
            # Find how many indices are in range [l, r]
            left = bisect.bisect_left(idx_list, l)
            right = bisect.bisect_right(idx_list, r)
            result.append(right - left)
        
        return result
