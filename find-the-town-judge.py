"""
Runtime Complexity: O(m+n) - 2d trust array and we traverse all the elements in it.
Space Complexity: O(n) - indegrees array of size 'n'
Yes, the code worked on leetcode.
Issues while coding- No
"""
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return -1
        indegrees = [0 for i in range(n)]
        for edge in trust:
            indegrees[edge[0]-1]-=1
            indegrees[edge[1]-1]+=1
        
        for i in range(n):
            if indegrees[i]==n-1:
                return i+1
        
        return -1
        