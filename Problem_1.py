# Runs on Leetcode
    # Runtime - O(n) n is length of trust
    # Space - O(k) where j is N


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if not trust:
            return 1
        
        array = [0 for i in range(N)]
        
        for i in trust:
            array[i[0] - 1] -= 1
            array[i[1] - 1] += 1
        
        for i in range(len(array)):
            if array[i] == N-1:
                return i+1
            else:
                continue
        return -1
