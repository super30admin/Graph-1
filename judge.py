'''
Space O(N) Solution (findJudge) :
Time Complexity : O(N) -> number of trust relationships
Space Complexity : O(N) -> number of people
Did this code successfully run on Leetcode : Yes
Explanation: Create one array which add's the indegree of a person in the array and reduces the same count when we see
the person is an outdegree

Space O(2N) Solution (findJudgeTwoArray):
Time Complexity : O(N) where N here is Edges E -> number of trust relationships
Space Complexity : O(N+N) = O(N)  where N here is Vertices V -> number of people
Did this code successfully run on Leetcode : Yes
Explanation: Create 2 lists of indegree and outdegree and check if the indegree is equal to n-1 and outdegree is 0
then everyone trusts this person and is the judge else no judge
'''


class Solution:

    def findJudgeTwoArray(self, N: int, trust: List[List[int]]) -> int:
        indegree = [0 for i in range(N + 1)]
        outdegree = [0 for i in range(N + 1)]
        for person in trust:
            out = person[0]
            in1 = person[1]
            indegree[in1] += 1
            outdegree[out] += 1

        for i in range(1, len(outdegree)):
            if indegree[i] == N - 1 and outdegree[i] == 0:
                return i

    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        people = [0 for i in range(N + 1)]
        for person in trust:
            out = person[0]
            in1 = person[1]
            people[in1] += 1
            people[out] -= 1

        for i in range(1, len(people)):
            if people[i] == N - 1:
                return i

        return -1