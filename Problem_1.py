"""
Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)
"""

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        """
        TC : O(V +E) no of edges and no of vertex
        SC : O(N)
        """
        if len(trust) == 0 and n > 1: return -1
        if n ==1 and len(trust) ==0 : return 1
        
        arr = [1 for i in range(0,n + 1)]
        arr[0] = 0
    
        
        for num in trust:
            arr[num[0]] -= 1
            arr[num[1]] += 1
           
        for i in range(n+1):
            if arr[i] == n:
                
                return i
            
        return -1
            
        