# TC: O(v+e)
# SC: O(v)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n<2:
            return n
        arr=[0]*n
        candidate=-1
        for edge in trust:
            truster=edge[0]
            trustee=edge[1]

            arr[truster-1]-=1
            arr[trustee-1]+=1

            if arr[trustee-1]==n-1:
                candidate=trustee
            
            if candidate!=-1 and arr[candidate-1]!=n-1:
                candidate=-1
        
        return candidate