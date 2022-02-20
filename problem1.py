#Time Complexity O(N)
#Space Complexity O(N)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0]*n
        for x in trust:
            indegrees[x[0]-1]-=1
            indegrees[x[1]-1]+=1
        for x in range(len(indegrees)):
            if indegrees[x] == n-1:
                return x+1
        return -1
            
        
