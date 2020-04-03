'''
Time Complexity : O(E) -> number of trust relationships
Space Complexity : O(n) -> number of people
Did this code successfully run on Leetcode : Yes
Explanation: Create 2 lists of indegree and outdegree and check if the indegree is equal to n-1 and outdegree is 0
then everyone trusts this person and is the judge else no judge
'''
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        indegree = [0 for i in range(N)]
        outdegree = [0 for i in range(N)]

        for person in trust:
            out = person[0]
            in1 = person[1]
            indegree[in1 - 1] += 1
            outdegree[out - 1] += 1

        for i in range(0, len(outdegree)):
            if indegree[i] == N - 1 and outdegree[i] == 0:
                return i + 1

        return -1