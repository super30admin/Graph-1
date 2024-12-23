class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1:
            return 1
        indeg = [0] * (n + 1)
        for tr in trust:
            indeg[tr[0]] -= 1
            indeg[tr[1]] += 1

        for i in range(1, n + 1):
            if indeg[i] == n - 1:
                return i
        return -1
        # time complexity is O(n)
        # space complexity is O(n)
