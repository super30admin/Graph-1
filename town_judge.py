# // Time Complexity :O(v+e)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        print(trust)
        li=[0 for i in range(n)]
        for i in range(len(trust)):
            li[trust[i][0]-1]-=1
            li[trust[i][1]-1]+=1
        for i in range(n):
            if li[i]==(n-1):
                return i+1
        return -1
            
        