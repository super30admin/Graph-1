'''
Time Complexity --> O(n)
Space Complexity --> O(n) for storing degree

Using a graph relationship we can solve this problem 
'''
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        degree = [0 for x in range(n)]
        for i in range(len(trust)):
            out_ = trust[i][0]-1
            in_ = trust[i][1]-1
            degree[out_]-=1
            degree[in_]+=1
        
        for i in range(len(degree)):
            if degree[i]==n-1:
                return i+1
        return -1
