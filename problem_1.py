# Time Complexity - O(V+E)
# Space Complexity - O(n)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        arr = [0] * n
        for each in trust:
            arr[each[0]-1] -= 1 
            arr[each[1]-1] += 1
        print(arr)
        for i in range(len(arr)):
            if arr[i] == n-1 :
                return i + 1
        return -1 
            

            

