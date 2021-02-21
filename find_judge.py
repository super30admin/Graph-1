# Time : O(V + E) 1st for loop traverses over egdes 2nd traverses over vertices
# Space : O(V)
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        indegree = [0 for _ in range(N)]
        
        # calculate indegree for each node
        for t in trust:
            indegree[t[0]-1] -= 1
            indegree[t[1]-1] += 1
            
        # traverse indegree array to find judge
        for i,deg in enumerate(indegree):
            if deg == N-1:
                return i+1
        return -1