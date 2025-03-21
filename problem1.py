# Time Complexity : O(V+E)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1:
            return 1
        
        net_degrees = [0] * (n+1)

        for p1, p2 in trust:
            # p1 trusts p2
            net_degrees[p1] -= 1
            net_degrees[p2] += 1

        for i,score in enumerate(net_degrees):
            if score == n-1:
                return i
        
        return -1