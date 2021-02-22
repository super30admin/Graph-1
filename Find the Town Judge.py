#time: O(n)
#space: O(n)
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        trustmap=[0] * (N+1)
        for i in trust:
            trustmap[i[0]]-=1
            trustmap[i[1]]+=1
        trustmap[0]=-1
        print(trustmap)
        for i in range(len(trustmap)):
            if(i!=0):
                if (trustmap[i]==N-1):
                    return i
        return -1
            
        
                
        