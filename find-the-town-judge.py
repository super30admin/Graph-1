# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        trust_score = [0] * (n + 1)
        for a, b in trust:
            trust_score[a] -= 1  # a trusts someone
            trust_score[b] += 1  # b is trusted by someone
        for i in range(1, n + 1):
            if trust_score[i] == n - 1:
                return i
        return -1
        