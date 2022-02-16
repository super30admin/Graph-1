# Time Complexity : o(n)
# Space Complexity: O(n)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return 0

        indegrees = [0]* (n)

        for people in trust:
            indegrees[people[0]-1] -= 1
            indegrees[people[1]-1] += 1

        for i in range(0,n):
            if indegrees[i] == n -1:
                return i + 1

        return -1