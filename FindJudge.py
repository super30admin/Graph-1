# Time Complexity: O(V+E), where V is the size of the trust array (for iterating over trust)and E is the number of people (for iterating over indegrees).
# Space Complexity: O(V), for storing the indegrees array.
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = []
        #Initilly fill the indegree array with 0's, Here we are taking length as n+1 to match the index numbers with the incoming numbers as indexes start from 0
        for i in range(0,n+1):
            indegrees.append(0)
        #Iterate through trust to find out each judge who trustes other and that judge is trusted by others
        for tr in trust:
            #First number in tr is the judge who trusts (Out-Degree)
            indegrees[tr[0]]-=1
            #Second number in tr is the judge who is trusted by first (In-degree)
            indegrees[tr[1]]+=1
        #Start iterating from 1 as we aligned the judge numbers with index numbers
        for j in range(1,n+1):
            #This condition make sure that the judge is trusted by everyone but doesn't trust any of them
            if(indegrees[j]==n-1):
                return j

        return -1


        