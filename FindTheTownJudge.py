'''
TC: O(E+V) is the edges in trusts input and the number of nodes
SC: O(n) - where n is the number of potential nodes
'''
from typing import List

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        res = [0]*(n+1)
        for x,y in trust:
            res[x]-=1
            res[y]+=1
        for i,v in enumerate(res):
            if v==n-1 and i!=0:
                return i
        return -1
s = Solution()
print(s.findJudge(2, [[1,2]]))
print(s.findJudge(3, [[1,3],[2,3]]))
print(s.findJudge(3, [[1,3],[2,3],[3,1]]))