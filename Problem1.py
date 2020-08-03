"""
// Time Complexity : o(n), where n is the number of key-value pairs
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        villagers = [0] * N #create an array that keeps track of indegrees and outdegrees

        for t in trust:
            v, j = t
            villagers[v - 1] -= 1 #outward edge
            villagers[j - 1] += 1  #inward edge
            
        for i in range(len(villagers)):
            if villagers[i] == N - 1: #villager that has N-1 in degrees is the answer
                return i + 1 
        return -1
        