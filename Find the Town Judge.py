# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if len(trust) < n-1:
            return -1
        trustedppl = [0] * (n+1)
        for pair in trust:
            trustedppl[pair[0]] -= 1
            trustedppl[pair[1]] += 1
        for i in range(1,len(trustedppl)):
            if trustedppl[i] == n-1:
                return i
        return -1