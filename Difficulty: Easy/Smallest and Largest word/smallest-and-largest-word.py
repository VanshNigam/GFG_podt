class Solution:
    def smallerAndLarge(self, s):
        words = s.split()
        min_word = words[0]
        max_word = words[0]

        for word in words:
            if len(word) < len(min_word):
                min_word = word
            # For max, update even if length is equal to get the **last** occurring
            if len(word) >= len(max_word):
                max_word = word

        return [min_word, max_word]
