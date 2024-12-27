# Explain your approach briefly at the top:
# The town judge can be identified based on the properties:
# 1. The judge is trusted by everyone else.
# 2. The judge trusts nobody.
# We use an array to calculate the "trust score" of each person:
# - Increase the score if someone is trusted by another person.
# - Decrease the score if a person trusts someone else.
# The person with a trust score of `n - 1` (trusted by everyone except themselves) is the judge.

# Time Complexity: O(n + trust.length)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # Edge case: if there's only one person and no trust relationships, they are the judge.
        if n == 1 and not trust:
            return 1
        
        # Initialize a list to keep track of trust scores
        trust_scores = [0] * (n + 1)
        
        # Process the trust relationships
        for a, b in trust:
            trust_scores[a] -= 1  # Decrease score for the person who trusts someone
            trust_scores[b] += 1  # Increase score for the person being trusted
        
        # Find the potential judge
        for i in range(1, n + 1):
            if trust_scores[i] == n - 1:  # The judge should be trusted by everyone else
                return i
        
        # If no judge found, return -1
        return -1
