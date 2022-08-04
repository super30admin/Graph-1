# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        judge = [0]*(n+1)
		# Keep a track of inward and outward degree.
		# We are doing -1 as well because judge can't trust anyone.
        for i,j in trust:
            judge[i] -= 1
            judge[j] += 1

        for j in range(1, n+1):
            if judge[j] == n-1:
                return j
        return -1
