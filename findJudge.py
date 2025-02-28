class Solution:
    # TC :O(m+n) m- length of trust, n- people
    # SC: O(n)
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0 :
            return -1
        indegree = [0]*n
        for i,o in trust:
            indegree[i-1] -= 1
            indegree[o-1] += 1
        print(indegree)
        for i in range(len(indegree)):
            if indegree[i] == n-1:
                return i+1
        return -1
        