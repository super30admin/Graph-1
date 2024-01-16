"""
Time Complexity : O(v+e) where v is the vertices in this case n and e is the number of edges in this case len(trust)
Space Complexity : O(v) where v is the vertices in this case n

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach:
1. Calcualte indegree and outdegree of each vertices
2. If Indegree == n-1, it means all people except judge trust the judge and outdegree = 0 means judge does not trust anyone
   If the above considtion satisfied return that vertex as judge else return -1
"""


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return -1
        outDegree = [0] * (n+1)
        inDegree = [0] * (n+1)

        for i, j in trust:
            outDegree[i] += 1
            inDegree[j] += 1

        for i in range(1, len(outDegree)):
            if outDegree[i] == 0 and inDegree[i] == n-1:
                return i

        return -1
