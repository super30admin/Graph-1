class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1 and not trust: return 1
        indegree = defaultdict(int)  #[indegree, 
        outdegree = defaultdict(int) #outdegree

        for i, j in trust:
            indegree[j] += 1
            outdegree[i] += 1

        for _n in range(1, n+1):
            if indegree[_n] == n-1 and outdegree[_n] == 0:
                return _n
        return -1

#TC V+E where V is no of people and E is number of relations
