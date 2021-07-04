"""
Time Complexity : O(n) 
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:        
        inDegrees = [0] * N
        
        for i in range(len(trust)):
            inDegrees[trust[i][0] - 1] -= 1
            inDegrees[trust[i][1] - 1] += 1
            
        for j in range(N):
            if inDegrees[j] == N - 1:
                return j + 1
            
        return -1