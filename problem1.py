#time O(N)
#space O(N)
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if trust == []:
            return 1
        indegree=collections.defaultdict(int)
        g=collections.defaultdict(list)
        for i in trust:
            g[i[1]].append(i[0])
            indegree[i[0]]+=1
            indegree[i[1]]+=0
        for i,j in indegree.items():
            if j==0:
                if len(g[i])==N-1:
                    return i
        return -1