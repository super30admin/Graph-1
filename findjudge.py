class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        """
        keyIdea:keep track of incoming and outgoing elements
        TC:O(V+E)
        SC:O(n)
        """
        
        indegrees=[0]*(n)
        for t in trust:
            indegrees[t[0]-1]-=1
            indegrees[t[1]-1]+=1
        for i in range(n):
            if indegrees[i]==n-1:
                return i+1
        return -1
        
        #  """
        # keyIdea:keep track of incoming and outgoing elements
        # TC:O(V+E)
        # SC:O(n)
        # """
        
        # indegrees=[0]*(n+1)
        # outdegrees=[0]*(n+1)
        # for t in trust:
        #     outdegrees[t[0]]+=1
        #     indegrees[t[1]]+=1
        
        # for i in range(1,n+1):
        #     if indegrees[i]==n-1 and outdegrees[i]==0:
        #         return i
        # return -1
        