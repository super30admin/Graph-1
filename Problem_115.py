# TC : O(n)
# SC : O(n)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if len(trust) < n - 1:
            return -1
        list1 = [0] * (n)
        for i in trust:
            list1[i[1]-1] += 1
            list1[i[0]-1] -= 1
        
        print(list1)
        for i in range(0, n):
            if list1[i] == n - 1:
                return i+1
        return -1
