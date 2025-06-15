# Time Complexity : O(len(trust))
# Space Complexity : O(n)
# Approach:
# 1. Create a result array of size n+1 initialized to 0.
# 2. For each trust pair (a, b):
#    - Decrease the count for person a by 1.
#    - Increase the count for person b by 1.
# If any person has a count of n-1, return that person as the judge.
class Solution:
    def findJudge(self, n: int, trust):
        if n == 1: return 1
        res = [0] * (n+1)
        for t in trust:
            res[t[0]] -= 1
            res[t[1]] += 1
        for i in range(n+1):
            if res[i] == n-1:
                return i
        return -1