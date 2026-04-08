# https://leetcode.com/problems/find-the-town-judge/description/

# Graph problem
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# TC: O(E) + O(V) => We need to first go over the entire input array of tuples (edges) to construct the indegrees
# then we need to traverse the entire indegrees array of size V
# SC: O(V) => indegrees array of size V

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0] * (n+1)

        if n == 1:
            return 1

        for i in range(len(trust)):
            tr = trust[i]
            # giving trust
            indegrees[tr[0]] -= 1
            # receiving trust
            indegrees[tr[1]] += 1

        for i in range(len(indegrees)):
            if indegrees[i] == n-1:
                return i

        return -1 