'''
class Node:
    def __init__(self, d):
        self.data=d
        self.next=None
        self.bottom=None
        
'''

class Solution:
     def flatten(self, root):
        from heapq import heapify, heapreplace, heappop
        h = []
        head, order = root, 0
        while head:
            h.append((head.data, order, head))
            head.next, head = None, head.next
            order += 1
        dummy = tail = Node(-1)
        while h:
            _, order, node = h[0]
            tail.bottom = tail = node
            if node.bottom:
                heapreplace(h, (node.bottom.data, order, node.bottom))
            else:
                heappop(h)
        tail.bottom = None
        return dummy.bottom