from collections import defaultdict
import heapq

class Solution:
    def sumOfModes(self, arr, k):
        n = len(arr)
        freq = defaultdict(int)
        heap = []  # max heap of (-frequency, value)

        # initialize first window
        for i in range(k):
            freq[arr[i]] += 1
        for val, count in freq.items():
            heapq.heappush(heap, (-count, val))

        def get_mode():
            # Ensure heap top matches current frequency
            while heap and -heap[0][0] != freq[heap[0][1]]:
                heapq.heappop(heap)
            return heap[0][1]

        result = get_mode()  # mode of first window

        # slide the window
        for i in range(k, n):
            # remove outgoing element
            out_elem = arr[i-k]
            freq[out_elem] -= 1
            # add new element
            in_elem = arr[i]
            freq[in_elem] += 1
            # push new frequencies into heap
            heapq.heappush(heap, (-freq[in_elem], in_elem))
            heapq.heappush(heap, (-freq[out_elem], out_elem))

            result += get_mode()

        return result

