# TC : O(V+E)
# SC : O(V)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        hashset = [0]* n
        
        for person, trust_person in trust:
            hashset[person-1] -=1
            hashset[trust_person-1] +=1
            
        for i in range(len(hashset)):
            if hashset[i]==n-1:
                return i+1
            
        return -1