class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return -1
        indegree = [0] * n
        for t in trust:
            indegree[t[0] - 1] -= 1
            indegree[t[1] - 1] += 1
        for i in range(n):
            if indegree[i] == n - 1:
                return i + 1
        return -1
