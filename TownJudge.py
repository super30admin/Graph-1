#Time complexity: O(len(trust))
#Space complexity: O(n)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree=[0]*(n+1)
        for i in trust:
            inn=i[0]
            out=i[1]
            indegree[inn]-=1
            indegree[out]+=1
        for i in range(1,len(indegree)):
            if indegree[i]==n-1:
                return i
        return -1
                
        