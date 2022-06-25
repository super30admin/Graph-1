class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        inDegree=[0 for i in range(n+1)]
        outDegree=[0 for i in range(n+1)]
        
        for item in trust:
            inDegree[item[1]]+=1
            outDegree[item[0]]+=1
            
        # if max(inDegree)==n-1 and outDegree[inDegree.index(max(inDegree))]==0:
        #     return inDegree.index(max(inDegree))
        
        for i in range(1,n+1):
            if inDegree[i]==n-1  and outDegree[i]==0:
                return i
        
        return -1
            
        