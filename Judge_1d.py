# Time : O(V+E)
# Space : O(V)
# Leetcode : Solved and submitted

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return 0
        
        # maintain a 1-d array of size n for all incoming and outgoing edges
        edges = [0 for _ in range(n)]
        
        # add 1 for incoming edges and subtract 1 for out-going edges
        for a, b in trust:
            edges[b-1] += 1
            edges[a-1] -= 1
            
        # at any index, if it gas n-1 as the value, then that person is the judge else return -1
        for i in range(n):
            if edges[i] == n-1:
                return i+1
        
        return -1
