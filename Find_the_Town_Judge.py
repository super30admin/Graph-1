class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0   :
            return -1
        
        indegree = [0] * (n+1)
        
        for i in trust:
            indegree[i[0]] -=1
            indegree[i[1]] +=1
        print(indegree)    
        for i in range(1,len(indegree)):
            if indegree[i] == n-1:
                return i
        
        return -1
        
