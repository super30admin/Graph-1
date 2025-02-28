class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0]*n
        outdegree = set()
        for a,b in trust:
            indegree[b-1] +=1
            outdegree.add(a)
        for i,ele in enumerate(indegree):
            if ele==n-1 and (i+1 not in outdegree):
                return i+1
        return -1
        