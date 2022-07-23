# Approach: Use indegree array
# for each person who is giving trust to another person , reduce their count by 1
# each person receiving trust gets count +1
# if max value in degrees arr == n-1 then that is the town judge else return -1
# TC: O(n) or O(V+E) as this is a graph problem
# SC: O(n)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1:
            return 1
        degrees = [0] * (n+1)
        max_i, max_t = 0, 0
        for tr in trust:
            degrees[tr[0]] -= 1
            degrees[tr[1]] += 1

        for i,d in enumerate(degrees):
            if d == n-1:
                return i
        return -1