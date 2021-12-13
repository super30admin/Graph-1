#Time O(v+e), space O(n)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        degree=[0]*(n+1)
    #Marking incoming and outgoing degrees
        for i in trust:
            degree[i[0]]-=1
            degree[i[1]]+=1
     #Traversing the array to find whose value is n-1 and returning it 
        for i in range(1,n+1):
            if degree[i]==n-1:
                return i
            
        return -1
