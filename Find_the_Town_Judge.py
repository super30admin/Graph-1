# Time Complexity : O(N + T), where N is the number of people and T is the number of trust relationships
# Space Complexity : O(N) 
from typing import List


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        # Create an array to track the trust count for each person
        trust_count = [0] * (N + 1)

        # Iterate over the trust relationships and update the trust count array
        for a, b in trust:
            trust_count[a] -= 1
            trust_count[b] += 1

        # Check if there is a person who is trusted by everyone except themselves
        for i in range(1, N + 1):
            if trust_count[i] == N - 1:
                return i

        return -1