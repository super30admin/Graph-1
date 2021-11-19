"""
https://leetcode.com/problems/find-the-town-judge/
TC: O(number of people + number of edges) whatever is max
Sc:O(n) for indegree array
"""


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0] * n
        for t in trust:
            indegree[t[0] - 1] = indegree[t[0] - 1] - 1
            indegree[t[1] - 1] = indegree[t[1] - 1] + 1
        for i in range(len(indegree)):
            ###trust score for that person is number of people -1 it means everyone except himself trust this person
            if indegree[i] == n - 1:
                return i + 1
        return -1




