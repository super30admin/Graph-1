# Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)
# Time Complexity: O(n + t),We loop through the trust list once (t edges), then loop through all n people once.
# Space Complexity: O(n),We store an indegrees array of size n+1.
# Approach:
# The town judge is trusted by everyone else but trusts nobody.
# For each trust pair [a, b], a trusts b, so we decrease a's score (a trusts someone, so a cannot be the judge)
# and increase b's score (b is trusted by someone).
# The judge is the one person whose final score equals n-1, meaning everyone else trusts them and they trust no one.

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0] * (n + 1)  # score for each person from 1 to n, index 0 is unused

        for i in trust:  # go through each trust pair
            indegrees[i[0]] -= 1  # person i[0] trusts someone, so they lose a point (cannot be judge if they trust anyone)
            indegrees[i[1]] += 1  # person i[1]] is trusted by someone, so they gain a point

        for i in range(1, n + 1):  # check every person from 1 to n
            if indegrees[i] == n - 1:  # trusted by everyone else and trusts nobody
                return i  # found the judge

        return -1  # no one matches, no judge exists