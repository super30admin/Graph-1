#Time Complexity :o(n2)
# Space Complexity :o(1)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no
class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        people = [0] * (n + 1)
        for x, y in trust:
            people[x] -= 1
            people[y] += 1
        for i in range(1, n + 1):
            if people[i] == n - 1:
                return i
        return -1