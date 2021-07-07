'''
Solution:
1.  Maintain a count of how many people are trusting a current person and how many people the current person
    is trusting.
2.  If the indegree count is V-1 and the outdegree count is 0, then he is the judge
3.  If no one of that sort exists, then return -1

Time Complexity:    O(E + V)    |   Space Complexity:   O(V)
--- Passed all testcases on Leetcode successfully
'''


class TownJudge:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:

        #   initialize indegrees and outdegrees arrays
        inDegrees = [0 for i in range(N + 1)]
        outDegrees = [0 for i in range(N + 1)]

        #   fill the indegrees and outdegrees by traversing all edges
        for edge in trust:
            trustor = edge[0]
            trustee = edge[1]
            inDegrees[trustee] += 1
            outDegrees[trustor] += 1

        #   find the judge by traversing all vertices
        for vertex in range(1, N+1):
            if (inDegrees[vertex] == N-1 and outDegrees[vertex] == 0):
                return vertex
            
        return -1
            