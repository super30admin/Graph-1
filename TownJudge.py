class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if trust==None:
            return -1
        indegrees=[0]*N
        for t in trust:
            indegrees[t[0]-1]-=1
            indegrees[t[1]-1]+=1
        
        for i in range(len(indegrees)):
            if indegrees[i]==N-1:
                return i+1
        return -1
Space is O(n)
Time is O(max(m,n))
