#Time complexity: O(n)
#space complexity : O(n)
#ran on leetcode: Yes
#calculate the indegree and outdegree for each person. The person with n indegree and 0 outdegree is the judge
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree=[0]*(n+1)
        outdegree=[0]*(n+1)
        for i in trust:
            indegree[i[1]]+=1
            outdegree[i[0]]+=1
        for i in range(1,len(indegree)):
            if(indegree[i]==n-1 and outdegree[i]==0):
                return i
        return -1

        
