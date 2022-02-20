class Solution:
    
    # Maintained a indgree array
    # if a e1 trusts e2 i am dec indegree of e1 and increasing indegree of e2
    # in the end i am traversing the indegree array 
    # if for any index value is 1 less then number of nodes return index
    
    # TC: O(V+E)
    # SC: O(V)
    
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        # Indecies are 0 to n-1. And keeping nth value at (n-1)th index.
        indegreesArray = [0 for i in range(n)]
        
        for t in trust:
            indegreesArray[t[0] - 1] -= 1
            indegreesArray[t[1] - 1] += 1
            
        for i in range(len(indegreesArray)):
            if (indegreesArray[i] == n-1):
                return i + 1
            
        return -1