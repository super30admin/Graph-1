#Time Complexity :O(n+E)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees=[0]*n
        for tr in trust:
            indegrees[tr[1]-1]+=1
            indegrees[tr[0]-1]-=1

        for i in range(n):
            if indegrees[i]==n-1:
                return i+1

        return -1