# Time:O(n+k) k is len of trust
# Space:O(n) for indeg array
# Leetcode: yes
# Issues:No 

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indeg  = [0]*(n+1)

        for tr in trust:
            indeg[tr[0]] -= 1
            indeg[tr[1]] += 1

        for i in range(1,n+1):
            if indeg[i] == n-1:
                return i
        
        return -1
            