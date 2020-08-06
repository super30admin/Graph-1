------------------------Find Judge --------------------------------------------

# Time Complexity : O(n) n is the number of persons in the town
# Space Complexity : O(N) as the extra indegree array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I created a indegree as array of trust. If a person trust b person, I am decrementing the truster and 
#incrementing the trustee. Then I am iterating through indegree array and finding the person with N-1 trustees.



class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        indegree = [0 for i in range(N+1)]
        
        for i,j in trust:
            indegree[i]-=1
            indegree[j]+=1
        
        for k in range(1,len(indegree)):
            if indegree[k] == N-1:
                return k
        return -1