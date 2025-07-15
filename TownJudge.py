# Time Complexity: O(n+t) where n for the checking the indegree and t is the len of trust list
# Space Complexity: O(n) for the indegree array
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if not trust and n == 1:
            return 1

        # Each person is represented from 1 to n
        indegree = [0] * (n+1)
        for a, b in trust:
            indegree[a] -= 1 # a trust someone
            indegree[b] += 1 # b is trusted by someone

        for person in range(1, n+1):
            if indegree[person] == n-1:
                return person

        return -1
