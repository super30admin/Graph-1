class Solution:
    def findJudge(self, n, trust):
        indegree = [0] * n
        for t in trust:
            a = t[0]
            b = t[1]
            indegree[a - 1] -= 1
            indegree[b - 1] += 1
        for i in range(n):
            if indegree[i] == n - 1:
                return i + 1
        return -1
