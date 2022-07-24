# Time Complexity: O(V+E)
# Space Complexity: O(V)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        l=[0]*n
        for i in trust:
            l[i[0]-1]-=1
            l[i[1]-1]+=1
        for i in range(len(l)):
            if l[i]==n-1: return i+1
        return -1
        