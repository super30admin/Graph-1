#Time Complexity: O(V+E)
#Space Complexity: O(V)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        #1st Solution
        indegree=[0]*(n+1)
        
        for i,j in trust:
            indegree[i]-=1
            indegree[j]+=1
            
        for i in range(1,n+1):
            if indegree[i]==n-1:
                return i
        
        return -1


    #Takes extra space in this for outdegree array 
    #2nd Solution
    #Takes extra space

        # indegree = [0 for _ in range(n+1)]
        # outdegree = [0 for _ in range(n+1)]
        # for i,j in trust:
        #     outdegree[i] += 1
        #     indegree[j] += 1
        # for i in range(1,n+1):
        #     if indegree[i] == n-1 and outdegree[i] == 0:
        #         return i
        # return -1