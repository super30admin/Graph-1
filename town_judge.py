class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        array=[0]*(n+1)
        for t in trust:
            array[t[0]]-=1
            array[t[1]]+=1
        
        for i in range(1,n+1):
            if array[i]==n-1:
                return i
        return -1

