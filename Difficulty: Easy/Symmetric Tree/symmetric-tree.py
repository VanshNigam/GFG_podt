class Solution:
    def isSymmetric(self, root):
        #Code Here
        
        def tree(root1, root2):
            if not root1 and root2:
                return False
            if not root2 and root1:
                return False
            if not root1 and not root2:
                return True
            if root1.data != root2.data:
                return False

            if not tree(root1.left, root2.right) or not tree(root1.right, root2.left):
                return False
            
            return True
        
        return tree(root.left, root.right)