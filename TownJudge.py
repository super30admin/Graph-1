'''
time complexity: O(n)
space complexity: O(n)
'''
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        g = [0 for _ in range(n)]

        for t in (trust):
            out = t[0]-1
            ins = t[1]-1
            g[out]-=1
            g[ins]+=1
        for i in range(len(g)):
            if(g[i]==n-1):
                return i+1
        return -1