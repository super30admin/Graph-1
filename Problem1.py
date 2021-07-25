# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# adding 1 if someone trusts me
# reducing one if i trust someone
# overall for a person if the value is n-1 then he will be the judge
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        count = [0]*n
        
        for i in trust:
            a = i[0]
            b = i[1]
            
            count[b-1] += 1
            count[a-1] -= 1
        
        print(count)
        for i in range(len(count)):
            if count[i] == n - 1:
                return i+1
        return -1