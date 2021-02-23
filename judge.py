# Time complexity - O(V+E) where V:vertices and E:egdes
# Space Complexity: O(V) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Indegree is noted for the trust list. At the end the node with trust value N-1 will be answer(judge). 

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        indeg = [0]*N
        for i,j in trust:
                indeg[i-1]-=1
                indeg[j-1]+=1
                
        for i in range(0,len(indeg)):
            if indeg[i] == N-1:
                return i+1
            
        return -1

            