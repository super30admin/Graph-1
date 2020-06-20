#Time complexity O(E+V) , number of edges and vertices
#Space complexity: O(V) number or vertices
'''
We calculate the in_degrees for each node, while decrementing by one when giving
the trust to someone. We iterate through the in_degrees array to check if
there's one with N-1 indegrees (meaning it received from everyone and did not
give trust to anyone). This is the judge
'''
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        in_degrees=[0]*N
        
        for pair in trust:
            in_degrees[pair[1]-1]+=1
            in_degrees[pair[0]-1]-=1
        
        for i,n in enumerate(in_degrees):
            if n==N-1:
                return i+1
        return -1
