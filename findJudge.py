class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # T: O(E + n), S: O(n)
        # Create arrays to track trust counts
        # trust_count[i] = [number of people i trusts, number of people who trust i]
        trust_count = [[0, 0] for _ in range(n + 1)]

        # Count trust relationships
        for a, b in trust:
            trust_count[a][0] += 1  # Person a trusts someone
            trust_count[b][1] += 1  # Person b is trusted by someone

        # Find the judge
        for i in range(1, n + 1):
            # A judge trusts nobody (0 outgoing) and is trusted by everyone else (n-1 incoming)
            if trust_count[i][0] == 0 and trust_count[i][1] == n - 1:
                return i

        # No judge found
        return -1
