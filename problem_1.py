class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1:
            return 1
        
        indeg = [0] * (n + 1)
        outdeg = [0] * (n + 1)
        
        for a, b in trust:
            outdeg[a] += 1
            indeg[b] += 1
        
        for person in range(1, n + 1):
            if indeg[person] == n - 1 and outdeg[person] == 0:
                return person
        return -1