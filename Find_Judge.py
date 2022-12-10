'''
Problem: https://leetcode.com/problems/find-the-town-judge/description/
Space Complexity: O(N) - Additional Space for maintaining Indegree and Outdegree
Time Complexity: O(N) - will go through the entire input list
Did it run on LC: Yes
Logic: for a judge 2 conditions are needed - Outdegree is 0, indegree is N-1
because everything has an edge to it except itself.
Hence calculate the indegree and outegree and check for the conditions 
for every node.
'''


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
       
        indegree = [0]*(n+1)
        #outdegree = [0]*(n+1)

        for src,dest in trust:
            indegree[src]-=1
            indegree[dest]+=1


        for i in range(1,n+1):
            if indegree[i] == n-1:
                return i

        return -1



