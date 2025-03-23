# Time O(n+len(trust))
# Space O(n)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if not trust: return -1 if n > 1 else 1
        trust_arr = [0] * (n+1)
        for a, b in trust:
            trust_arr[a] -= 1
            trust_arr[b] += 1

        for i in range(n+1):
            if trust_arr[i] == n-1:
                return i
        return -1