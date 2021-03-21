class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        """
        TC: O(N)
        SC: O(N)
        """
        indegree = [0] * (N+1)
        outdegree = [0] * (N+1)
        
        for trusts in trust:
            indegree[trusts[0]] += 1
            outdegree[trusts[1]] += 1

        for i in range(1,N+1):    
            if indegree[i] == 0 and outdegree[i] == N-1:
                return i
        return -1