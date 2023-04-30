class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == len(trust): return -1
        trust_count = [0 for i in range(n)]
        for per,tru in trust:
            trust_count[per-1] -= 1
            trust_count[tru-1] += 1
        for count in range(len(trust_count)):
            if trust_count[count] == n-1:
                return count+1
        return -1