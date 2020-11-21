"""
Time : O(N)
Space : O(N)
Leetcode : Yes
Explanation : Maintain only one array that increases when person i is trusted and decreases when i trusts someone
Then only one person will have value == N - 1 by the end.
"""
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        indegree = [0] * (N + 1)
        
        for i in range(len(trust)):
            first = trust[i][0]
            second = trust[i][1]
            
            indegree[first] -= 1
            indegree[second] += 1
            
        for i in range(1, N+1):
            
            if indegree[i] == N - 1:
                return i
            
        return -1