# The findJudge method identifies the town judge based on trust relationships.

# Use an array to track trust scores:
# - Decrease trust for those who trust others.
# - Increase trust for those being trusted.

# The town judge has a trust score of N-1. Return their index if found, else return -1.

# TC: O(N + T) - N is the number of people, T is the number of trust pairs.
# SC: O(N) - Space for the trust score array.


from typing import List


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        Trusted = [0] * (N+1)
        for (a, b) in trust:
            Trusted[a] -= 1
            Trusted[b] += 1
            
        for i in range(1, len(Trusted)):
            if Trusted[i] == N-1:
                return i
        return -1