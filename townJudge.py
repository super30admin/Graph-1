# Space Complexity - o(n)
# Time Complexity - o(n)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        indegrees = [0]*(n+1)

        for ai, bi in trust:
            indegrees[ai]-=1
            indegrees[bi]+=1

        for i in range(1,n+1):
            if indegrees[i] == n-1:
                return i

        return -1
