class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        ## T.C = O(n)
        ## S.C = O(n)        

        in_degrees = [0]*n

        for i,j in trust:
            in_degrees[i-1] -= 1
            in_degrees[j-1] += 1
        
        for i in range(n):
            if in_degrees[i] == n - 1:
                return i + 1
        
        return -1
