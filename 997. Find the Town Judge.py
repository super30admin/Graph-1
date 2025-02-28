#Time: O(vertex + edges)
#space: O(vertex)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        arr= [0]* (n+1)
        for t in trust:
            arr[t[0]] -=1
            arr[t[1]] +=1
        for i in range(1, len(arr)):
            if arr[i] == n-1:
                return i 
        return -1
        
