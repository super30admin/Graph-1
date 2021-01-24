"""
Approach: BFS traversal of graph

In this approach we will use an array of length of N+1 where each index represents the trust level(indegree-outdegree) of a person. As we traverse through the array we will update the array like this

If [1,2] is encountered the decrease the trust level of 1 and increase the trust level of 2
Visually 1 -> 2. That means trust level of 1 is -1(0-1) and trust level of 2 is 1(0+1)

So the array looks like this at the end [-1,1]. 

Now if at any index a trust level of N-1 is found then that person is the judge.

TC: O(V+E)
Sc: O(N)

where N = no of people
V = no of vertices in the graph
E = no of edges in the graph
"""

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N == 0:
            return -1
        
        tLevels = [0] * (N + 1)
        
        for i in trust:
            tLevels[i[0]] -= 1
            tLevels[i[1]] += 1
            
        for i in range(1, N+1):
            if tLevels[i] == N-1:
                return i 
            
        return -1
                