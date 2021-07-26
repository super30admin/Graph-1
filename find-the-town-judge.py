# Time Complexity: O(V+E)
# Space Complexity: O(V+E)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # Null condition check
        if n == 0 or len(trust) == 0:
            return 0
        
        
        # Initialize indeg with 0 and length n
        indeg = [0]*n
        
        # Create an indegrees array
        # For each value in trust, if it is going out, decrement 1
        # # For each value in trust, if it is going in, increment 1
        for t in trust:
            indeg[t[0]-1] -= 1
            indeg[t[1]-1] += 1
        
        # Loop through the indeg array
        # If the value is n-1 (all trust that person), judge is found
        for i in range(len(indeg)):
            if indeg[i] == n-1:
                return i+1
        # If not, return -1
        return -1
            