"""
TC: O(V+E)
SC: O(n)
"""

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        ingress = [0] * n
        
        for t in trust:
            ingress[t[0]-1] -= 1
            ingress[t[1]-1] += 1
        
        for person in range(len(ingress)):
            if ingress[person] == n-1:
                return person+1
        return -1