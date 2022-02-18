# Timecomplexity : o(max(len(trust),n))
# Space complexity:o(n)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        indegrees = [0]*n
        
        for a in trust:
            
            indegrees[a[0]-1] -=1
            indegrees[a[1]-1] +=1
        print(indegrees)
        for b in range(len(indegrees)):
            if indegrees[b] == n-1:
                 return b+1
       
                    
        return -1
            
            
        
        