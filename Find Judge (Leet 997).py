'''
Time: O(trust)
Space: O(n)
'''

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        indeg = [0 for x in range(n+1)]

        for li in trust:
            out = li[0]
            inc = li[1]
            print(out, inc)
            indeg[out] -= 1
            indeg[inc] += 1

        for i in range(1,len(indeg)):
            if indeg[i] == n-1:
                return i
        return -1