#######997. Find the Town Judge##################################################################################
// Time Complexity : O(n)
// Space Complexity : O(n) -> for in degree and out degree array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
I created 2 list in degree and out degree, indegree is populated when with second element in list that is the person who is trusted and outdegree we populate the count of 1st element of list that is if he trust someone. At end we can check the in degree array with element having count-1 and out degree array having count 0

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n==1 and len(trust)==0:
            return n
        indegree=[0]*(n+1)
        outdegree=[0]*(n+1)
        #print(indegree,outdegree)
        for i in trust:
            indegree[i[1]]+=1
            outdegree[i[0]]+=1
        for i,val in enumerate(indegree):
            if val==n-1 and outdegree[i]==0:
                return i
        return -1
        
        
        
