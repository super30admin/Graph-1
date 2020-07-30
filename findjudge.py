# STEPS:
# track the outgoing and incoming edges from every node.
# check if more than one node or 0 node has no outgoing edges, return -1. (only town judge can trust no one).
# check the node with 0 outgoing edges, have incoming edges equal to N-1 (all others must trust the judge).
# Time complexity - O(E+N)
# Space complexity - O(2N)
# Did this solution run on leetcode? : yes
# Did you encounter any issues while running this code? : No
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N==1 and not trust: return 1
        incoming = [0] * N
        outgoing = [0] * N
        
        for tedge in trust:
            out, inc = tedge
            incoming[inc-1] +=1
            outgoing[out-1] += 1
        print(outgoing, incoming)
        # check outgoing array to find the edge with 0 outgoing edge
        cand = None
        for i, out in enumerate(outgoing):
            if out==0:
                if cand: return -1  # more than 1 node with 0 outgoing edge
                cand = i
        
        if cand is None: return -1 # no node with 0 outgoing edge
        
        return cand+1 if incoming[cand] == N-1 else -1


# STEPS:
# track the outgoing and incoming edges from every node.
# check if more than one node or 0 node has no outgoing edges, return -1. (only town judge can trust no one).
# check the node with 0 outgoing edges, have incoming edges equal to N-1 (all others must trust the judge).
# Time complexity - O(E+N)
# Space complexity - O(N)
# Did this solution run on leetcode? : yes
# Did you encounter any issues while running this code? : No
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N==1 and not trust: return 1
        edgeinfo = [0] * N
        
        for tedge in trust:
            out, inc = tedge
            edgeinfo[out-1] -= 1
            edgeinfo[inc-1] += 1
        
        for cand, edge in enumerate(edgeinfo):
            if edge == N-1:
                return cand+1
        return -1
        