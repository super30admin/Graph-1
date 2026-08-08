## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)
# Time Complexity: O(N + E)
# - We iterate through the trust array of size E once to compute net degrees: O(E).
# - We iterate through the range from 1 to N to find the town judge: O(N).
# - Overall Time Complexity: O(N + E), where N is the number of people and E is the number of trust relationships.
#
# Space Complexity: O(N)
# - We create an array 'indegrees' of size (N + 1) to track the net trust score for each person: O(N).

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # Array to track net trust count (In-degree minus Out-degree) for people 1 through n
        indegrees = [0] * (n + 1)

        # For every trust relationship [a, b]:
        # 'a' trusts 'b', so 'a' loses 1 point (trusts someone, violating judge property 2)
        # 'b' gains 1 point (is trusted by someone, building towards judge property 1)
        for trustee, trusted in trust:
            indegrees[trustee] -= 1
            indegrees[trusted] += 1

        # Check each person from 1 to n
        # The judge trusts nobody (-0 out-degree) and is trusted by everyone else (+(n - 1) in-degree),
        # yielding a net score of exactly n - 1.
        for i in range(1, n + 1):
            if indegrees[i] == n - 1:
                return i

        # If no person satisfies the judge condition, return -1
        return -1