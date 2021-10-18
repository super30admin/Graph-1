# Did this code successfully run on Leetcode : YES

# approach
# calculate difference between indegrees and outdegrees
# TC: O(N)
# SC: O(N)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        degrees = [0 for _ in range(n)]
        for [i, j] in trust:
            degrees[j-1] += 1
            degrees[i-1] -= 1
        for d in range(n):
            if degrees[d] == n-1:
                return d+1
        return -1