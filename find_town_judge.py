# O(N) - TC and SC
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0]*(n + 1)
        outdegree = [0]*(n + 1)
        for i in range(len(trust)):
            a,b = trust[i]
            indegree[b] += 1
            outdegree[a] += 1
        
        for i in range(1, len(indegree) ):
            if indegree[i] == n - 1 and outdegree[i] == 0:
                return i
        return -1
            
            
        
