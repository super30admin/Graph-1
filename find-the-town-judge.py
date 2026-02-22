''' Time Complexity : O(V + E) 
    Space Complexity : O(V) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0] * (n+1)
        for i,j in trust:
            indegree[j] += 1
            indegree[i] -= 1
        for i in range(1,n+1):
            if indegree[i] == n-1:
                return i
        
        return -1