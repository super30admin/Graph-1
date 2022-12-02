#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0] * n
        for t in trust:
            indegree[t[0] - 1] += -1
            indegree[t[1] - 1] += 1
        
        for i in range(n):
            if indegree[i] == n-1:
                return i+1
        
        return -1
        