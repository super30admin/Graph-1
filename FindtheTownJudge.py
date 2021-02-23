# Time Complexity : O(V+E)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Creating Graph for all the connections.
# Initialize an indegree array with N as the number of persons
# The person who is giving trust the value will be decremented and the person who is getting trust the valus is incremented
# Then iterate over the indegree array to check if the valus is N-1 if it is return index + 1
# Else return -1


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:

        indegrees = [0] * (N)

        for i in range(len(trust)):
            indegrees[trust[i][0] - 1] -= 1
            indegrees[trust[i][1] - 1] += 1

        for i in range(len(indegrees)):
            if indegrees[i] == N - 1:
                return i + 1

        return -1