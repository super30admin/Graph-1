'''
Time Complexity - O(N)
Space Complexity - O(N)

Approach - Increment the count of the person who is being trusted and decrement the count of the person who trusts
In the end, if their is a judge, the count of number of times, he is trusted will be N-1.
Iterate through the relations array and check if any of its count is N-1, return the position number else return -1
if not found
'''

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        relations = [0]*(N+1)
        
        for edge in trust:
            
            # Incoming edge
            relations[edge[1]]+=1
            
            # Outgoing edge
            relations[edge[0]]-=1
            
        for i in range(1,N+1):
            
            if relations[i] == N-1:
                return i
            
        return -1