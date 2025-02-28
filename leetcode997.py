# Time Complexity :- O(n)
# Space Complexity :- O(n)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1 and not trust:
            return 1
        trustCounts = [0] * (n + 1)
        for a, b in trust:
            trustCounts[a] -= 1  # Outgoing trust
            trustCounts[b] += 1  # Incoming trust
        for i in range(1, n + 1):
            if trustCounts[i] == n - 1:
                return i
        
        return -1