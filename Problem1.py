# Problem 1 : Find the Town Judge
# Time Complexity : O(m+n) where m is the number of people and n is the number of trust realtionship
# Space Complexity : O(m) where m is the number of people 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # define the indegress array with the length of (n+1) with 0
        indegress = [0] * (n+1)

        # loop through trust list
        for tr in trust:
            # decrement the value of tr[0] person in indegress array
            indegress[tr[0]] -= 1
            # increment the value of tr[1] person in indegress array
            indegress[tr[1]] += 1

        # loop from 1 to n+1 
        for i in range(1, n+1):
            # check if the value of ith person in indegress is n-1
            if indegress[i] == n-1:
                # if it is then ith person is judge so return i
                return i
        # if there is no judge then return -1
        return -1
        