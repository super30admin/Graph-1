class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0 for i in range(n)]
        for a, b in trust:
            indegree[b - 1] += 1
            indegree[a - 1] -= 1
        
        for i in range(n):
            if indegree[i] == n - 1:
                return i + 1
        return -1