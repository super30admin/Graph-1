# Time Complexity : O(N) where N is number of people
# Space Complexity : O(N) where N is number of people
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0 for _ in range(n)]
        
        for t in trust:
            pA, pB = t
            indegrees[pB - 1] += 1
            indegrees[pA - 1] -= 1
        
        for i in range(len(indegrees)):
            if indegrees[i] == n-1:
                return i + 1
        
        return -1