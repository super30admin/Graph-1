'''
997 Find the Town Judge
https://leetcode.com/problems/find-the-town-judge/description/

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:
    Conditon 1: The town judge trusts nobody.
    Condition 2: Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.


Example 1:
Input: n = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Constraints:
1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n

Solution:
1. Indegree and Outdegree
Each person is a node and the trust relationship is an edge
for each trust: # O(E)
    get the start and end node
    subtract 1 for the start node (outgoing arrow)
    add +1 for the end node (incoming arrow)
If net degree of any node = n-1, then that node is the judge.
Else return -1

Why should the judge have n-1 net degree?
Because based on Condition 1 and 2, judge does not trust anybody (outdegrees = 0). Everybody else trusts the judge (indegrees = n-1). Thus, net degree = in - out = n-1
https://youtu.be/RpaJCO7oUik?t=4037
Time: O(V+E), Space: O(V)
'''
from typing import List
def findJudge(n: int, trust: List[List[int]]) -> int:
    if n <= 0:
        return -1

    # degrees[i] = indegree of person 1 - outdegree of person i
    degrees = [0]*(n+1) # degrees[0] is a dummy
    for edge in trust: # O(E)
        if len(edge) == 2: # check for empty list
            node_out = edge[0]
            node_in = edge[1]
            degrees[node_out] -= 1
            degrees[node_in]  += 1

    for node in range(1,n+1): # O(V)
        if degrees[node] == n - 1:
            return node
    return -1

def run_tests():
    tests = [([[1,2]], 2, 2), ([[1,3],[2,3]], 3, 3), ([[1,3],[2,3],[3,1]], 3, -1), ([[]], 1, 1)]
    for test in tests:
        trust, n, ans = test[0], test[1], test[2]
        judge = findJudge(n, trust)
        print(f"\ntrust = {trust}")
        print(f"num people = {n}")
        print(f"judge = {judge}")
        passed = (ans == judge)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()
