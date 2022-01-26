class Solution:
    # Time Complexity - O(V + E)
    # Space Complexity - O(V)
    def findJudge(self, n: int, trust) -> int:
        if n == 0: return -1
        indegrees = [0] * n
        for edge in trust:
            indegrees[edge[0] - 1] -= 1
            indegrees[edge[1] - 1] += 1

        for i in range(len(indegrees)):
            if indegrees[i] == n - 1:
                return i + 1

        return -1