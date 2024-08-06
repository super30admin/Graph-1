#tc=O(n)
#sc=O(n)
from typing import List
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        outdegree = [0]*(n+1)

        for arr in trust:
            outdegree[arr[0]]-=1
            outdegree[arr[1]]+=1
        
        for i in range(1, n+1):
            if outdegree[i] == n-1:
                return i
        return -1