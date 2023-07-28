from ast import List


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0 for i in range(n)]

        for idx, ele in enumerate(trust):
            indegree[ele[0]-1] -= 1
            indegree[ele[1]-1] += 1
        
        for i in range(len(indegree)):
            if indegree[i] == n -1:
                return i + 1

        return -1