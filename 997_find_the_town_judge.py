'''
## Problem 997: The maze

## Author: Neha Doiphode
## Date:   08-22-2022

## Description:
    In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
    If the town judge exists, then:
        The town judge trusts nobody.
        Everybody (except for the town judge) trusts the town judge.
        There is exactly one person that satisfies properties 1 and 2.

    You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

    Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

## Examples:
    Example 1:
        Input: n = 2, trust = [[1,2]]
        Output: 2

    Example 2:
        Input: n = 3, trust = [[1,3],[2,3]]
        Output: 3

    Example 3:
        Input: n = 3, trust = [[1,3],[2,3],[3,1]]
        Output: -1

## Constraints:
    1 <= n <= 1000
    0 <= trust.length <= 104
    trust[i].length == 2
    All the pairs of trust are unique.
    ai != bi
    1 <= ai, bi <= n


## Time complexity: O(V + E), as we are looping over edges(trust) and vertices(n) both.

## Space complexity: O(n), where n is number of people which is len(indegrees) auxiliary array that is used.

'''

from typing import List, Optional
from collections import deque

def get_input():
    print("Enter the number of people in the town: ", end = "")
    n = int(input())
    print("Enter the number of pairs in the trust array: ", end = "")
    number_of_pairs = int(input())
    trust = []
    print("Enter integers in the pair with spaces")
    for row in range(number_of_pairs):
        print(f"Pair {row + 1}: ")
        pair = input()
        pair = [int(val) for val in pair.split()]
        trust.append(pair)

    return n, trust

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return -1

        indegrees = [0] * n

        for edge in trust:
            # edge = [a person trusts b person]
            # outgoing edge - subtract 1
            indegrees[edge[0] - 1] -= 1
            # incoming adge - add 1
            indegrees[edge[1] - 1] += 1

        for i in range(n):
            if indegrees[i] == n - 1:
                return i + 1
        return -1

# Driver code
solution = Solution()
n, trust = get_input()
print(f"Input number of people: {n}")
print(f"Input trust array: {trust}")
print(f"Output: Town judge: {solution.findJudge(n, trust)}")
