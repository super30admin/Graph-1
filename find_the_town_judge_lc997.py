"""
Author: Srinidhi
Did it run on LC: Yes

Space Complexity: O(N) - Additional Space for maintaining Indegree and Outdegree
Time Complexity: O(N) - will go through the entire input list

Logic: for a judge 2 conditions are needed - Outdegree is 0, indegree is N-1
because everything has an edge to it except itself.
Hence calculate the indegree and outegree and check for the conditions 
for every node.
"""
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        #if there are more people then the
        #number of degrees possible
        #then we cannot have complete judge requirmenent
        if N-1 > len(trust):
            return -1
        
        indegree = [0]*(N+1)
        outdegree = [0]*(N+1)
        
        for src,dest in trust:
            outdegree[src]+=1
            indegree[dest]+=1
            
        
        for i in range(1,N+1):
            if indegree[i] == N-1 and outdegree[i] == 0:
                return i
        
        return -1