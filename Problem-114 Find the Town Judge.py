# 997. Find the Town Judge
# https://leetcode.com/problems/find-the-town-judge/

# Logic: Consider the dependency of tristing someone as a graph. 
# We can consider indegree to a node as +1 and out-degree from 
# a node as -1. We calculate the sum of degrees for all the nodes. 
# The node with n-1 sum will be the judge as all the other nodes 
# trust him and he doesnt trust anyone. If no n-1 count is present, 
# we can say there is no judge available.

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        count = [0 for _ in range(n+1)]
        
        for i in trust:
            count[i[0]] -= 1
            count[i[1]] += 1
            
        for i in range(1,n+1):
            if count[i] == n-1:
                return i
        return -1