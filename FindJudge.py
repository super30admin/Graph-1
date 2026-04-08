# Time Complexity : O(V + E), where V is the number of people and E is the number of trust relationships.
# Space Complexity : O(V), for the indegrees array.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We use an array to count trust levels: losing trust (out-degree) subtracts, gaining trust (in-degree) adds.
# The town judge should be trusted by everyone else but trust no one.
# So we just find the person with an in-degree of n−1.

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0] * (n+1)

        for tr in trust:
            indegrees[tr[0]] -= 1
            indegrees[tr[1]] += 1

        for i in range(1, n+1):
            if indegrees[i] == n - 1:
                return i
        
        return -1


        
