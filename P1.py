#Time: O(V+E)
#Space: O(N)
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:

        indegree = [0]*N

        for t in trust:
            indegree[t[0]-1]-=1
            indegree[t[1]-1]+=1

        for i in range(N):
            if indegree[i]==N-1:
                return i+1

        return -1
