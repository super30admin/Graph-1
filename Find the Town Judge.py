# Time:- O(E)
# Space:- O(N)
# Approach:- We use an indegree and outdegree array. In the indegree array we store the incoming trust to that person and in the outdegree array we store the persons that person
# trusts. According to the problem the town judge trusts no one but everyone trusts the townjudge so the indegree of the town judge must be n-1 and the outdegree of the town judge must be 0, if both of these conditions have been satisfied we have found the town judge.

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if len(trust) < N - 1:
            return -1
    
        indegree = [0] * (N + 1)
        outdegree = [0] * (N + 1)

        for a, b in trust:
            outdegree[a] += 1
            indegree[b] += 1

        for i in range(1, N + 1):
            if indegree[i] == N - 1 and outdegree[i] == 0:
                return i
        return -1
        
    