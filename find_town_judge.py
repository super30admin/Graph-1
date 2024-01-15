# TC: O(N)
# sc: O(N)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        dict1={}
        if n==1 and len(trust)==0:
            return n
        if n==0 or len(trust)==0:
            return -1
        
        dict2={}
        for i in range(1,n+1):
            dict1[i]=[]
            dict2[i]=0
        
        
        for t in trust:
            if t[0] in dict1:
                dict1[t[0]].append(t[1])
            if t[1] not in dict2:
                dict2[t[1]]=1
            else:
                dict2[t[1]]+=1

        for i in dict1:
            if dict1[i]==[] and dict2[i]==n-1:
                return i
        
        return -1
            
        
            
        