#Time Complexity:O(V+E)
#Space Complexity:O(V)
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        result=[0 for i in range(N)]							#create an array to hold indegrees
        for i in range(len(trust)):								#for every trust dependency given
            result[trust[i][0]-1]-=1							#decrease the indegree of the person trusting
            result[trust[i][1]-1]+=1							#inrease the indegree of the person trusted
        if N-1 in result: 										#if in the indegree array any person has N-1 trust return the person as judge
            return result.index(N-1)+1
        return -1 												#else return -1