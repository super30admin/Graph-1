# TC: O(V+E)
# SC: O(V+E)
# Create indegrees array of people. Indegree which is N-1 is the judge
class Solution:
    def findJudge(self, N, trust):
        indegrees = [0 for i in range(N)]
        for t in trust:
            indegrees[t[0] - 1] -= 1
            indegrees[t[1] - 1] += 1
        
        for i in range(N):
            if indegrees[i] == N-1:
                return i+1
        return -1