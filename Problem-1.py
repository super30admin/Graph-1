class Solution:
    def findJudge(self, n: int, trust):

        if trust == None:
            return 0
        if n == 1:
            return 1
        if n - 1 > len(trust):
            return -1

        indegrees = [0] * (n + 1)

        for t in trust:
            indegrees[t[0]] -= 1  # outgoing edge
            indegrees[t[1]] += 1  # incoming edge

        for i in range(1, n + 1):
            if indegrees[i] == n - 1:
                return i
        return -1

