"""
Each person gains 1 "point" if they are trusted by others
and loses 1 "point" for each person they trust
TC: O(n)
SP:O(n)

"""
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:

        if len(trust) < N - 1:
            return -1

        trust_scores = [0] * (N + 1)

        for a, b in trust:
            trust_scores[a] -= 1
            trust_scores[b] += 1
        
        for i, score in enumerate(trust_scores[1:]):
            if score == N - 1:
                return i+1
        return -1