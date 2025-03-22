#time complexity o(n)
#space complexity o(n)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0] * (n+1)

        for tr in trust:

            indegrees[tr[0]] -= 1
            indegrees[tr[1]] += 1

        for i in range(1,n+1):
            if indegrees[i] == n - 1:
                return i
        
        return -1
        