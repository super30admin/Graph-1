"""
Time Complexity : O(v+e)
Space Complexity : O(v)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach: 
We need to maintain an array for topological sort. While iterating through the array, we decrease the degree by
1 of whom who is trusting and increase the degree by 1 of who is being trusted. At last we will iterate 
over the array to check whos value is N-1 would be the judge
"""


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        indegrees = [0] * N
        for t in trust:
            trustedby = t[0]
            trusted = t[1]
            indegrees[trustedby - 1] -= 1
            indegrees[trusted - 1] += 1
        
        for i in range(len(indegrees)):
            if indegrees[i] == N-1:
                return i + 1
        return -1
