#  Time Complexity : O(V + E) where V is the number of people and E is the number of realtionsips  
#  Space Complexity : O(V)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: We create an array having length equal to the number of people given. Everytime the person trusts somebody then we reduce the count by 1 and if the person is trusted by someone else we increase the count by 1. The index in the array having count 1 less than the total number of people will be the town judge.  

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0] * (n + 1)

        for tr in trust:
            indegrees[tr[0]] -= 1
            indegrees[tr[1]] += 1
        
        for i in range(1, n + 1):
            if indegrees[i] == n - 1:
                return i
        
        return -1
