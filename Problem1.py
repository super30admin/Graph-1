## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n==0:
            return -1
        indegree = [0]*n
        for i in trust:
            indegree[i[0]-1] = indegree[i[0]-1] -1
            indegree[i[1]-1] = indegree[i[1]-1] +1
        for i in range(n):
            if indegree[i]==n-1:
                return i+1
        return -1
    
    #Time Complexity: O(V+E)
    #Space Complexity: O(V)
    #Approach: Exploit the property of indegree. Create an array named indegree. 
    # Traverse through the trust array, if a is encountered decrease a by one which is the
    #  index in indegree array and the add one to the position. If b is encountered decrease
    #  the value by one and at that index value subtract that value by 1. After complete traversal, 
    # if an element in the indegree value is n-1 then return it to be the judge else return -1. 