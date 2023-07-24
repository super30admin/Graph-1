# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        arr = [0 for _ in range(n)]

        for val in trust:
            trustedby = val[0]
            trusts = val[1]

            arr[trustedby-1] -= 1
            arr[trusts-1] += 1

        for i in range(n):
            if arr[i] == n-1:
                return i+1
        return -1