#Time Complexity : O(V+E)
#Space Complexity : Theta(V)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0 for i in range(n)]
        
        for i in range(len(trust)):
            indegrees[trust[i][0]-1] -= 1
            indegrees[trust[i][1]-1] += 1
        
        for i in range(len(indegrees)):
            if indegrees[i] == n-1:
                return i + 1
        return -1
