# Time Complexity : O(N) for each operation.
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use a list and maintain indegree and return if its number of people.
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        ind=[0]*n
        for i in trust:
            ind[i[0]-1]-=1
            ind[i[1]-1]+=1
        for i in range(len(ind)):
            if ind[i]==n-1:
                return i+1
        return -1