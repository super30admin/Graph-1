#Time Complexity: O(v+e)
#Space Complexity: O(v)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        lst = [0]*(n)
        for vals in trust:
            lst[vals[0]-1] -= 1
            lst[vals[1]-1] += 1
            
        for i in range(len(lst)):
            if lst[i] == n-1:
                return i+1
        return -1
            