"""
Graph approach --
TC  -- O(V+E)
SC -- O(n)
"""


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n is None or trust is None or len(trust) is None: return -1

        # create an empty array of length n
        indegrees = [0 for i in range(n)]

        # for each list of list in trust array --
        # 1. if outgoing edge subtract 1
        # 2. if incoming edge add 1
        for edge in trust:
            indegrees[edge[0] - 1] -= 1
            indegrees[edge[1] - 1] += 1

        # traverse through the indegrees to find an index whose value is  n-1
        # n-1 because trust is len(n) and there's only 1 person who is trusted by everyone
        # and this person trusts no one
        for i in range(n):
            if indegrees[i] == n - 1:
                return i + 1

        return -1 