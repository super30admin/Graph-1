class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        # Solution, O(n) (O(V+E))
        if(N==1):
            return 1
        
        indegree = [0 for i in range(0,N)]
        
        for i,j in trust:
            indegree[i-1]-=1
            indegree[j-1]+=1
        
        for i in range(0,N):
            if(indegree[i]==N-1):
                return i+1
        
        return -1
