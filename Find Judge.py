"""
997. Find the Town Judge
Time Complexity - O(N)
Space Complexity - O(2*N)
Indegree represents person who trusts other and outdegree represents the trust gained from people.With given trust array built the indegree and outdegree array and then index for which indegree is 0 and outdegree is N-1 means that person is town judge, else return -1"""
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        indegree = [0]*(N+1)
        outdegree = [0]* (N+1)
        
        for value in trust:
            indegree[value[0]] += 1
            outdegree[value[1]] +=1
        
        for i in range(1,N+1):
            if indegree[i] == 0 and outdegree[i] == N-1:
                return i
        return -1