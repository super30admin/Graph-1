class Solution(object):
    def findJudge(self, N, trust):
        if len(trust)<N-1:
            return -1
        indegree=[0]*(N+1)
        outdegree=[0]*(N+1)
        for a,b in trust:
            outdegree[a]+=1
            indegree[b]+=1
        for i in range(1,N+1):
            if indegree[i]==N-1 and outdegree[i]==0:
                return i
        return -1
        
#Time-complexity: O(E)
#Space-complexity: O(N)