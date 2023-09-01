# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        if (len(trust) == 0) and (n == 1): 
            return 1
        count = ([0] * (n + 1))
        for person in trust:
            count[person[0]] -= 1
            count[person[1]] += 1
        for person in range(len(count)):
            if count[person] == (n - 1):
                return person
        return -1