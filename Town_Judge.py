#Time:O(m+n)
#Space:O(m+n) for m vertices and n edges
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0]*(n+1)
        outdegree = [0]*(n+1)
        for out_val,in_val in trust:
            indegree[in_val]+=1
            outdegree[out_val]+=1
        for i in range(1,n+1):
            if indegree[i]==n-1:
                if outdegree[i]==0:
                    return i
        return -1