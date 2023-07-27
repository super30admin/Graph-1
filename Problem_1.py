"""
Problem : 1

Time Complexity : O(V+E)
Space Complexity : O(V)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating a array which will store how many people does a particular person trusts
if a person is trusted by all people except self, then that person is the twon judge
"""

# Find Town Judge

class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        s=[0 for _ in range(n)]

        for tr in trust:
            s[tr[0]-1]-=1
            s[tr[1]-1]+=1
        
        for i in range(n):
            if s[i]==n-1:
                return i+1
        return -1