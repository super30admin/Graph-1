#// Time Complexity : O(V+E) 
# // Space Complexity : O(V) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        inorder = [0] * (n + 1)
        for i,j in trust:
            inorder[i] -= 1
            inorder[j] += 1
        
        for i in range(1,len(inorder)):
            if inorder[i] == n - 1:
                return i
        
        return -1

# Approach:
# The problem can be solved by using a frequency array to count the number of people who trust each person
# and the number of people who are trusted by each person. The judge is the person who is trusted
# by n-1 people and trusts no one.
