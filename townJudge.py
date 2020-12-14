# Finding town judge suing indegree array
#Time COmplexity: O(i)
#Spaace Complexity: o(n)
def findJudge(self, N: int, trust: List[List[int]]) -> int:
    indegrees = [0 for i in range(N)]
    for trust in trust:
        indegrees[trust[0]-1] = indegrees[trust[0]-1] - 1
        indegrees[trust[1]-1] = indegrees[trust[1]-1] + 1
    for i in range(N):
        if indegrees[i] == N-1:
            return i + 1
    return -1