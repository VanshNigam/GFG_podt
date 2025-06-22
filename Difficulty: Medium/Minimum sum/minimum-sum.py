import sys
sys.set_int_max_str_digits(500000)
class Solution:
    def minSum(self, arr):
        # code here
        arr = sorted(arr)
        s1 = []
        s2 = []

        for i in range(len(arr)):
            if i % 2 == 0:
                s1.append(str(arr[i]))
            else:
                s2.append(str(arr[i]))
        num1 = int("".join(s1)) if s1 else 0
        num2 = int("".join(s2)) if s2 else 0

        return num1 + num2