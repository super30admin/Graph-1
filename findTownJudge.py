#Time Complexity = O(V+E)
#Space Complexity = O(N)

def findJudge(self, n: int, trust: List[List[int]]) -> int:
    inDegree = [0] * n
    outDegree = [0] * n
    for a, b in trust:
        outDegree[a - 1] += 1
        inDegree[b - 1] += 1

    # print(inDegree,outDegree)
    for i in range(n):
        if outDegree[i] == 0 and inDegree[i] == n - 1:
            return i + 1
    return -1