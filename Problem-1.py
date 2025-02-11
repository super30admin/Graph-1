'''
    Time Complexity: O(V+E)
    Space Complexity: O(V)
'''
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        degreeList = [0 for _ in range(n)] 

        for rel in trust: 
            degreeList[rel[0] - 1] -= 1
            degreeList[rel[1] - 1] += 1

        for i in range(n):
            if degreeList[i] == n - 1:
                return i+1

        return -1