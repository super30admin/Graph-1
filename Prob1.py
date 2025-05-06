class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # Method 1 - 2 indegree array - TC - V+E and SC - 2V
        # indegree=[0 for _ in range(n+2)] #1 to n, so for loop till n+2
        # outdegree=[0 for _ in range(n+2)] #1 to n, so for loop till n+2

        # for a,b in trust:
        #     outdegree[a]+=1
        #     indegree[b]+=1
        
        # for i in range(1,n+1):
        #     if indegree[i]==n-1 and outdegree[i]==0:
        #         return i
        
        # return -1

        # Method 1 - 2 indegree array - TC - V+E and SC - V
        indegree=[0 for _ in range(n+2)] #1 to n, so for loop till n+2

        for a,b in trust:
            indegree[a]-=1
            indegree[b]+=1
        
        for i in range(1,n+1):
            if indegree[i]==n-1:
                return i
        
        return -1

