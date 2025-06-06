#User function Template for python3

class Solution:
    def search(self, pattern, text):
        d = 256           # Total number of characters (ASCII)
        q = 101           # A prime number for modulus
        m = len(pattern)
        n = len(text)
        p = 0             # Hash value for pattern
        t = 0             # Hash value for current text window
        h = 1
        ans = []

        # Calculate h = (d^(m-1)) % q
        for i in range(m - 1):
            h = (h * d) % q

        # Initial hash values for pattern and first text window
        for i in range(m):
            p = (d * p + ord(pattern[i])) % q
            t = (d * t + ord(text[i])) % q

        # Slide the pattern over the text
        for i in range(n - m + 1):
            # If hash values match, check actual characters
            if p == t:
                if text[i:i + m] == pattern:
                    ans.append(i + 1)  # 1-based indexing

            # Calculate hash of next window
            if i < n - m:
                t = (d * (t - ord(text[i]) * h) + ord(text[i + m])) % q
                if t < 0:
                    t += q

        return ans


