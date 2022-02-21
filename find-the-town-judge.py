'''
TC: O(n)
SC: O(n)
'''
class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        indeg = {i:0 for i in range(1, n+1)}
        outdeg = {i:0 for i in range(1, n+1)}
        
        for t in trust:
            indeg[t[1]] += 1
            outdeg[t[0]] += 1
        
        for i in range(1, n+1):
            if indeg[i] == n - 1 and outdeg[i] == 0:
                return i
        
        return -1
        
        