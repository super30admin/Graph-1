# Used an array to keep indegrees of the judge and subtracted 1 for each person who trusts someone else
# and added 1 for each person who is trusted by someone else.
# Time Complexity: O(n)
# Space Complexity: O(n)


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return -1
        
        indegrees = [0] * n
        for t in trust:
            indegrees[t[0] - 1] -= 1
            indegrees[t[1] - 1] += 1
        
        for i in range(n):
            if indegrees[i] == n - 1:
                return i + 1
        return -1