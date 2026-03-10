# Time Complexity : O(n + t), t = number of trust pairs
# Space Complexity : O(n), to track trust counts
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Track two counts for each person: number of people they trust and number of people who trust them.
# 2. The town judge trusts nobody (trusts count = 0) and is trusted by n-1 people.
# 3. Scan all people and return the one satisfying these conditions. Return -1 if none.

from typing import List

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        trusts = [0] * (n + 1)  # number of people each person trusts
        trusted_by = [0] * (n + 1)  # number of people who trust each person
        
        for a, b in trust:
            trusts[a] += 1
            trusted_by[b] += 1
        
        for i in range(1, n + 1):
            if trusts[i] == 0 and trusted_by[i] == n - 1:
                return i
        return -1