# Time Complexity : O(N) where N is number of nodes in the binary tree
# Space Complexity : O(N) where N is number of nodes in the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Cohort Morris Inorder Traversal
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        curr = root
        result = []
        while curr is not None:
            if curr.left == None:
                result.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right is not None and pre.right != curr:
                    pre = pre.right
                
                if pre.right == None:
                    pre.right = curr
                    curr = curr.left
                else:
                    result.append(curr.val)
                    pre.right = None
                    curr = curr.right
        
        return result
                