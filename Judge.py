# TC - O(V+E)
# SC - O(V)
class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        if len(trust) < n-1:
            return -1

        degree = [0] * (n + 1)

        for (truster, trustee) in trust:
            degree[trustee] += 1
            degree[truster] -= 1

        for person, tvote in enumerate(degree[1:], 1):
            if tvote == n - 1:
                return person

        return -1
