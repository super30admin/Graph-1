class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # arr=[0]*(n)
        # for i,j in trust:
        #     print(i,j)
        #     arr[i-1]-=1
        #     arr[j-1]+=1
        # print(arr)
        # for i in range(len(arr)):
        #     if arr[i]==n-1:
        #         return i+1
        # return -1
        if n==1:
            return 1
        d={}
        for i,j in trust:
            if i-1 not in d :
                d[i-1]=-1 
            if j-1 not in d:
                d[j-1]=1
            else:
                d[i-1]-=1
                d[j-1]+=1
        for k,v in d.items():
            if v==n-1:
                return k+1
        return -1
        print(d)