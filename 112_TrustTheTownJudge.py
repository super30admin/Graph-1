'''
Accepted on leetcode(997)
Time - O(N)
space - O(N)
check for 2 conditions given in question and use topological sort for dependency questions.
Create 2 arrays, fill them by going over trust array. Then check the condition to return TJ.
'''


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        # base case
        if len(trust) == 0:
            return 1 if N == 1 else -1

        # keeps track of our incoming edges
        # if a person has no incoming edges(i.e., he trusts no one, then it is false )
        t = [False for i in range(N)]
        # if someone trusts a person add q to that position.
        trust_someone = [0 for i in range(N)]

        for i in range(len(trust)):
            a = trust[i][0]
            b = trust[i][1]

            trust_someone[b - 1] += 1
            t[a - 1] = True

        for i in range(N):
            if t[i] is False and trust_someone[i] == N - 1:
                return i + 1
        return -1