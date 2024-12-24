class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        arr = [0]*(n)
        for ed in trust:
            arr[ed[0]-1] -= 1
            arr[ed[1]-1] += 1
        print(arr)
        for i in range(len(arr)):
            if arr[i] == n-1:
                return i+1
        return -1 
