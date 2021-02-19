'''
    Time Complexity:
        O(V+E)
        (where V = number of persons,
        E = number of [trustor, trustee] relationships)

    Space Complexity:
        O(V) (where V = number of persons)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Topological Sort.
'''

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trust_me_count = {}

        for person in range(1, N + 1):
            trust_me_count[person] = 0

        for trustor, trustee in trust:
            trust_me_count[trustor] -= 1
            trust_me_count[trustee] += 1

        for person, trustor_count in trust_me_count.items():
            if trustor_count == N - 1:
                return person

        return -1
