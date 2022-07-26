# Time Complexity: O(V+E)
# Space Complexity: O(V)
class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        indegrees=[0 for _ in range(n)]
        for i,j in trust:
            indegrees[i-1]-=1
            indegrees[j-1]+=1
        print(indegrees)
        try:
            return indegrees.index(n-1)+1
        except ValueError as ve:
            return -1