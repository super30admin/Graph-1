# Approach: Using in-degree array
# Reduce their count by 1, for every person who is trusting another person
# Every person receiving trust gets count +1
# If maxVal in degrees arr == n - 1 then that is the town judge else return -1
# TC: O(n) or O(V+E)  - since it's a graph problem
# SC: O(n)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1:
            return 1
        degrees = [0] * (n+1)
        for tr in trust:
            degrees[tr[0]] -= 1
            degrees[tr[1]] += 1

        for i, d in enumerate(degrees):
            if d == n-1:
                return i
        return -1