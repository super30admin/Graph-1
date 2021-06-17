# TC: O(V + E) where V are the number of people given by N and E are the edges that establish trust among the people. 
# SC: O(N) since we are creating an inDegree array for storing the in degree of every person. 

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if len(trust) == 0 and n == 1: 
            return 1
        
        inDegree = [0]*n
        for i,j in trust:
            inDegree[i - 1] -= 1 
            inDegree[j - 1] += 1
        
        for i in range(len(inDegree)): 
            if inDegree[i] == n - 1: 
                return i + 1
        
        return -1
