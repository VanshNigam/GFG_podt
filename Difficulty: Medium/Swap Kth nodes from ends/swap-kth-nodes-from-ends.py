'''
class Node:
    def __init__(self, x):
        self.data = x
        self.next = None
'''
class Solution:
    def swapKth(self, head, k):
        node = head
        for _ in range(k - 1):
            node = node.next
            if node is None:
                # "k" greater than list's length
                return head
        kth_node = node
        length = k - 1
        while node:
            length += 1
            node = node.next
        node = head
        for _ in range(length - k):
            node = node.next
        node.data, kth_node.data = kth_node.data, node.data
        return head