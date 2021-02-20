class Solution:
    #Solution 1
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        #Approach: Two arrays
        #Time Complexity: O(E)
        #Space Complexity: O(N)
        
        if len(trust) < N - 1:
            return -1
        
        netDegrees = [0 for _ in range(N)]
        
        for edge in trust:
            netDegrees[edge[0] - 1] -= 1
            netDegrees[edge[1] - 1] += 1
            
        for i in range(N):
            if netDegrees[i] == N - 1:
                return i + 1
            
        return -1
    
    #Solution 2
    """
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        #Approach: Two arrays
        #Time Complexity: O(E)
        #Space Complexity: O(N)
        
        if len(trust) < N - 1:
            return -1
        
        outDegrees = [0 for _ in range(N)]
        inDegrees = [0 for _ in range(N)]
        
        for edge in trust:
            outDegrees[edge[0] - 1] += 1
            inDegrees[edge[1] - 1] += 1
            
        for i in range(N):
            if outDegrees[i] == 0 and inDegrees[i] == N - 1:
                return i + 1
            
        return -1
    """