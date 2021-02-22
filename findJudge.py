# Time Complexity : O(V + E) vertices plus edges
# Space Complexity : O(N) N the input.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        inDegrees = [0 for i in range(N)]

        #edges 
        for i in trust:
            inDegrees[i[0] - 1] -= 1
            inDegrees[i[1] - 1] += 1
        
        #vertices
        for i in range(len(inDegrees)):
            if inDegrees[i] == N-1:
                return i+1
            
        return -1