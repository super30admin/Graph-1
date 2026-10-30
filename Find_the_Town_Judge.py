# Time Complexity : O(V+E)
# Space Complexity : O(V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Creating Graph for all the connections.
# Initialize an indegree array with N+1 as the number of persons as there is no person at 0th index
# The person who is giving trust the value will be decremented and the person who is getting trust the valus is incremented
# Then iterate over the indegree array with i starting from 1 to check if the value is N-1 if it is return i
# Else return -1


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0] * (n + 1)
        for i in range(len(trust)):
            indegree[trust[i][1]] += 1
            indegree[trust[i][0]] -= 1

        for i in range(1, len(indegree)):
            if indegree[i] == n - 1:
                return i
        return -1