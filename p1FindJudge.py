"""
time: O(N)
space: O(N)

"""

from collections import Counter
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        count = collections.Counter()
        counted = collections.Counter()
        
        for watcher, watched in trust:
            count[watcher] += 1
            counted[watched] += 1       
        for i in range(1, n+1):
            if count[i] == 0 and counted[i] == n-1:
                return i
        return -1