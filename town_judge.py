"""
Time Complexity: O(V + E)
Space Complexity: O(V)
"""
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        degrees = [0] * N   
        for t in trust:
            degrees[t[0]-1] -= 1
            degrees[t[1]-1] += 1
             
        for i in range(N):
            if degrees[i] == N-1: return i+1
            
        return -1