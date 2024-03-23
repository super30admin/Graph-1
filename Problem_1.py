'''
Time Complexity - O(V+E)
Space Complexity - O(n) for maintaining the indegrees

Works on Leetcode.
'''

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0 for i in range(n+1)] #creat indegrees array
        for tr in trust: #for each edge in the edges
            indegrees[tr[0]]-=1 #decrease indegree of the outgoing node
            indegrees[tr[1]]+=1 #increase indegree of the incoming node
        for i in range(1,n+1):
            if indegrees[i] == n-1: #the node which has the trust of everyone will have indegree no. of nodes - 1
                return i #return the node number
        return -1 #no node found return -1
        