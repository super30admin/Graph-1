# Approach: Similar to topolgical sort problems(course schedule, the independant node here is the judge)
# Create an adjacency array called indegrees decrement trust level of node if it trusts anybody
# Increment trust level of node if other nodes trust it
# Judge is the node which has trust level equal to N-1 

# Time - O(V + E) since either Vertices or Edges could be maximum
# Space - O(V) where V is the vertices
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        if len(trust) < N - 1:
             return -1
        
        indegrees = [0 for _ in range(N)]
        
        for t in trust:
            
            # since indices are from 0 ... t vals are 1 to N
            indegrees[t[0] - 1] -= 1
            indegrees[t[1] - 1] += 1
         
        for index in range(N):
            if indegrees[index] == N - 1:
                return index + 1
            
        return -1
            
        
        