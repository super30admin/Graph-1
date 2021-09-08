# Time Complexity : O(V+E) where V and E are vertices and Edges of the graph
# Space Complexity : O(V)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0 for i in range(n)]
        #Iterate over all the Elements of Trust Array
        for t in trust:
            indegree[t[1]-1]+=1
            indegree[t[0]-1]-=1
        for i in range(len(indegree)):
            # if the edge has all incoming nodes
            if indegree[i] == n-1:
                return i+1
        # if no edge has all incoming nodes, return -1
        return -1