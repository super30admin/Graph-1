# Time Complexity: O(N + E), where N - number of people, E - number of edges
# Space Complexity: O(N)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return -1

        # Indegree array to store number of trusts for each person
        indegree = [0 for x in range(n)]

        # If a person trusts another, decrement their indegree and,
        # if a person is trusted by another, increment their indegree
        for i, j in trust:
            indegree[i - 1] -= 1
            indegree[j - 1] += 1

        # Return the person with indegree n - 1
        for i in range(n):
            if indegree[i] == n - 1:
                return i + 1

        return -1