class Solution:

    """
    Description: find a town judge from relations between N people
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach: Use of nd-array, 2 pass
    - create an array of size N
    - Use the indices + 1 to update the array (first pass)
      + add 1 for every index when judge - 1 is the person someone trust
      + reduce 1 for every index for each person
    - find if any value in nd-array matches with N - 1
      + if yes: return index + 1
      + if no: return -1
    """
    
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        ndarray = [0]*N
        
        # first pass:
        for i, j in trust:
            ndarray[j - 1] += 1
            ndarray[i - 1] -= 1
            
        for i, item in enumerate(ndarray):
            if item == N - 1:
                return i + 1
            
        return -1
