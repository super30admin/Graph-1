"""
Time Complexity : O(V + E) where V is the no of people and E is the lenght of trust list 
Space Complexity : O(V) where V is the no. of people
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return -1
        indegrees = [0]*n
        # Compute indegrees going through the trust list and incrementing the indegree
        # for the person who's being trusted and decrementing the indegree for the
        # person who is trusting.
        for t in trust:
            indegrees[t[0] - 1] -= 1
            indegrees[t[1] - 1] += 1
        # Now we traverse through the indegrees array and find the indegrees equals
        # one less than the given people then we return that person's incrmented index
        for i in range(n):
            if indegrees[i] == n - 1:
                return i + 1
        return - 1