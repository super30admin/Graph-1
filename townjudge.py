# Time O(N)
# Space O(N)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if not trust: 
            if n == 1: return n
        indegrees = [0 for i in range(n+1)]
        for t in trust:
            indegrees[t[0]] -= 1
            indegrees[t[1]] += 1
        # print(indegrees)
        
        x = [i for i, v in enumerate(indegrees) if v == n-1]
        return (x[0] if x else -1)