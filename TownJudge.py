"""
In a town, there are n people labeled from 1 to n. 
There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] 
representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists 
and can be identified, or return -1 otherwise.
"""

# Time Complexity : O(max(v,e)) where v = vertices, e = edges
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0] * (n+1)
        tr = [0]
        for tr in trust:
            indegrees[tr[0] - 1] -= 1
            indegrees[tr[1] - 1] += 1
            
        for i in range(len(indegrees)):
            if (indegrees[i] == n-1):
                return i+1
        return -1
            

        