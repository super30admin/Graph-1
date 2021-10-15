#Time Complexity : O(v+e)
#Space Complexity : O(e)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        li = [0]*n
        for i in trust:
            li[i[0]-1] -= 1
            li[i[1]-1] += 1
            
        for i in range(len(li)):
            if li[i] == n-1:
                return i+1
        return -1