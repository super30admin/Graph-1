class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:

        if len(trust)<n-1:
            return -1
        
        out=[0]*(n+1)
        into=[0]*(n+1)

        for a,b in trust:
            out[a]+=1
            into[b]+=1

        print(out,into)
        for i in range(1,n+1):
            if into[i]==n-1 and out[i]==0:
                return i

        return -1

        