#  https://leetcode.com/problems/find-the-town-judge/

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0] * (n+1)

        for i in range(len(trust)):
            indegrees[trust[i][0]] -= 1            
            indegrees[trust[i][1]] += 1
        
        for i in range(1,n+1):
            if indegrees[i] == n-1:
                return i
        
        return -1

# TC: O(len(trust)+n) ==> O(V+E)
# SC: O(n)