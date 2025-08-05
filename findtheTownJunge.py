#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        indegree = [0] * (n + 1)
        outdegree = [0] * (n + 1)
        
        # Step 1: Build indegree and outdegree
        for a, b in trust:
            outdegree[a] += 1
            indegree[b] += 1

        # Step 2: Identify judge
        for i in range(1, n + 1):
            if indegree[i] == n - 1 and outdegree[i] == 0:
                return i
        
        return -1
            