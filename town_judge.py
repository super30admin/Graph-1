'''
The solution lies around the simple problem of indegree and outdegree array.

Although before I used some complex hash_map and stuff, to solve this out, but I just felt, this was way easier to solve, following class.

Time complexity : O(V+E) --> Fill in the inward_outward array. and go through the array.
Space Complexity :O(V)--> Number of vertices in the array.
'''

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:

        in_out_degree=[0 for i in range(n+1)]

        for i in range(len(trust)):

            in_out_degree[trust[i][0]]-=1
            in_out_degree[trust[i][1]]+=1


        for i in range(1,len(in_out_degree)):
            if(in_out_degree[i]==n-1):
                return i



        return -1
