"""
Leetcode: https://leetcode.com/problems/find-the-town-judge/solution/
Approach: Using one array
The town judge is the only person who could possibly have indegree - outdegree equal to N - 1.

(N is the number of people, and E is the number of edges (trust relationships))
Time Complexity:
O(E). We loop over the trust list once. The cost of doing this is O(E).
We then loop over the people. The cost of doing this is O(N), in the worst case, E has to be bigger, and so we can simply drop the N, leaving O(E).
Space Complexity : O(N). We're allocating an array of length N.
"""


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if len(trust) < N - 1:
            return -1

        trust_scores = [0] * (N + 1)

        for a, b in trust:
            trust_scores[a] -= 1
            trust_scores[b] += 1

        for i, score in enumerate(trust_scores[1:], 1):
            if score == N - 1:
                return i
        return -1