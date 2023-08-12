# Time Complexity : O(len(trust))
# Space Complexity : O(n)

# The code ran on Leetcode

# Initialize an array with zeroes. Iterate over trust and increment arr[trust[1]] by 1 and decrement arr[trust[0]] by one. The Judge will have value as n-1

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:

        arr = [0]*(n+1)

        for ai, bi in trust:
            arr[ai] -= 1
            arr[bi] += 1

        for i in range(1, n+1):
            if arr[i] == n-1:
                return i
        return -1
