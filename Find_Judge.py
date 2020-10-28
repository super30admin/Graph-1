#Time - O(N)
#Space - O(N) N is the total number of people 
# using an array and incrementing and decrementing to the inex of the people.


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        if N==1:
            return 1
        
        arr = [0 for i in range(N+1)]
        
        for i,j in trust:
            arr[j] += 1
            arr[i] -= 1
        
        
        for i in range(len(arr)):
            if arr[i] == N-1:
                return i
        return -1
