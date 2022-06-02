#Time Complexity : O(N)
#Space Complexity: O(N) N is the number of people
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0] * n
        for i in trust:
            indegree[i[0] - 1] -= 1
            indegree[i[1] - 1] += 1
            
        for i in range(len(indegree)):
            if indegree[i]==n-1:
                return i + 1
            
        return -1