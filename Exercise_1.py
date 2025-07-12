# S30 Problem #115 Find the Town Judge
#LeetCode #997 https://leetcode.com/problems/find-the-town-judge/description/

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        #outdegree => number of directed edges going out of it. Here: number of other people that person trusts
        #indegree => number of directed edges going into it. Here number of people that trust that person
        #judge has outdegree of 0 and indegree of n-1
        # instead of taking two arrays: indegree and outdegree. Just maintain one and add or substract 
        if len(trust) < n-1:
            return -1
        indegree = [0] * (n+1)
        for f,t in trust:
            indegree[f] -= 1
            indegree[t] += 1
        for i in range(1,n+1):
            if indegree[i] == n-1:
                return i
        return -1