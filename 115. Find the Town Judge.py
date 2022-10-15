#Time Complexity: O(V+E)
#Space Complexity: O(V)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n is None: return None
        if n == 1: return 1
        arr = [0 for i in range(n+1)]
        for x in trust: 
            arr[x[0]] -= 1
            arr[x[1]] += 1
        for x in range(len(arr)):
            if arr[x] == n-1:
                return x
        return -1