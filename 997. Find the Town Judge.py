'''
T = O(2n)
S = O(1)

Approach:
Maintain an Indegree array that is a running array that holds the net inflow and outflow of all the judges
Form this indegree array and iterate through it and find the index+1 which is equal to the N-1 value
'''

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        inDegrees = [0] * N
        
        for i in range(len(trust)):
            inDegrees[trust[i][0]-1] -= 1
            inDegrees[trust[i][1]-1] += 1
        print(inDegrees)
        for i in range(len(inDegrees)):
            if inDegrees[i] == N-1:
                return i+1
        return -1
            