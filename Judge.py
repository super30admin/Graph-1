"""997. Find the Town Judge
TC - O(V+E)
SC -O(E)"""
class Solution:
    
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0]*n

        for t in trust:
            indegrees[t[0]-1]-=1
            indegrees[t[1]-1]+=1
        print(indegrees)
        for i in range(len(indegrees)):
            if indegrees[i]==n-1:
                return i+1
        return -1
        