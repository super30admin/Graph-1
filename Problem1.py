'''
Problem:  Find the Town Judge
Time Complexity: O(V+E), where E is elements in trust aaray and V is n
Space Complexity: O(n), for indegree and outdegree array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        calculated indegree and outdegree of each person
        if indegree is n-1 and outdegree is 0 then that person is judge   
'''

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0] * n
        outdegree = [0] * n
        
        for t in trust:
            outdegree[t[0]-1]+=1
            indegree[t[1]-1]+=1
        
        print(indegree)
        print(outdegree)

        for i in range(n):
            judge = -1
            if indegree[i]==n-1 and outdegree[i] == 0:
                judge = i+1
                break

        return judge

