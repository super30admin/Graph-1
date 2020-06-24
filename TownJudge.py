#Time Complexity : O(V+E) where V is vertices and E is edges
#Space Complexiy : O(E) where E is edges
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        indegrees = [0]*N
        for t in trust:
            indegrees[t[1]-1] +=1
            indegrees[t[0]-1]-= 1
        for i in range(N):
            if indegrees[i] == N-1:
                return (i +1)
        return -1  