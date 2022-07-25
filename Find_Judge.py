# Time Complexity : O(n) + O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

class Solution:
    def findJudge(self, n: int, trust) -> int:
        result = [0]*n
        for i in trust:
            result[i[0]-1] -= 1
            result[i[1]-1] += 1
        for i in range(len(result)):
            if result[i] == n-1:
                return i+1
        return -1


print(Solution().findJudge(4, [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]]))
