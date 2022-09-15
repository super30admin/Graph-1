# Time complexity : O(V+E) --> V = n and E = len(trust)
# Space complexity : O(2*n)
# Leetcode : Solved and submitted

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return 0
        
        # maintain the incoming and out-going edges
        in_edges = [0 for _ in range(n)]
        out_edges = [0 for _ in range(n)]
        
        # update the edges array for each edge in trust
        for a, b in trust:
            in_edges[b-1] += 1
            out_edges[a-1] += 1
            
        # check for person who has n-1 incoming edges and 0 out-going edges, that person is the judge
        for i in range(n):
            if in_edges[i] == n-1 and out_edges[i] == 0:
                # return index + 1
                return i+1
        # return -1 if no preson could be a judge
        return -1
