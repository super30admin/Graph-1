class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0] * n
        for t in trust:
            indegrees[t[1] -1] += 1
            indegrees[t[0] -1] -= 1
        for i in range(len(indegrees)):
            if indegrees[i] == n-1:
                return i+1
        return -1
            
# Time Complexity: O(V+E)
# Space Complexity: O(V)