# 997. Find the Town Judge
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegress = [0 for _ in range(n+1)]

        for t in trust:
            indegress[t[0]] -= 1
            indegress[t[1]] += 1

        print(indegress)

        for i in range(1,n+1):
            if indegress[i] == n-1: return i
            
        return -1


        