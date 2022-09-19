# TC: O(V+E)
# SC: O(V) = O(n)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0 for _ in range(n)]
        
        for edge in trust:
            indegrees[edge[0]-1] -= 1
            indegrees[edge[1]-1] += 1
        for i in range(n):
            if indegrees[i] == n-1:
                return i+1
        return -1