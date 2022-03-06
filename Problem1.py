# // Time Complexity : O(n) where n is the number of people. 
# // Space Complexity : O(n) where n is the number of people. 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        hm = [0] * n
        for i,j in trust:
            hm[i-1] -= 1
            hm[j-1] += 1
        for i in range(len(hm)):
            if hm[i]  == n-1:
                return i+1
        return -1
