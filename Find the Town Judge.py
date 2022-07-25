""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        arr = [0] * n
        for t in trust:
            arr[t[0] - 1] -= 1
            arr[t[1] - 1] += 1
        for i in range(len(arr)):
            if arr[i] == n - 1:
                return i + 1
        return -1

