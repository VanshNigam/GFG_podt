#User function Template for python3

class Solution:
    # Function to sort a linked list of 0s, 1s and 2s.
    def segregate(self, head):
        # If the list is empty or contains only one node, return head as it is already sorted.
        if not head or not head.next:
            return head
        
        # Create a temporary pointer for traversing the linked list.
        temp = head
        lst = []
        
        # Traverse the linked list and store the data in a list.
        while temp:
            lst.append(temp.data)
            temp = temp.next
        
        # Sort the list.
        lst.sort()
        
        # Update the linked list with the sorted values.
        temp = head
        for val in lst:
            temp.data = val
            temp = temp.next
        
        return head





#{ 
 # Driver Code Starts
# Initial Template for Python 3


class Node:

    def __init__(self, data):
        self.data = data
        self.next = None


def printList(node):
    while node:
        print(node.data, end=" ")
        node = node.next
    print()


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().strip().split()))
        head = None
        if arr:
            head = Node(arr[0])
            tail = head
            for value in arr[1:]:
                tail.next = Node(value)
                tail = tail.next

        printList(Solution().segregate(head))
        print("~")

# } Driver Code Ends