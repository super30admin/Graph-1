#Time Complexity : O(N + E), where N is the number of people in the town and E is the number of trust relationships
#Space Complexity :O(n^2)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No

from ast import List


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        trust_count = [0] * (n + 1)  
        is_trusted_by = [set() for _ in range(n + 1)]

        for a, b in trust:
            trust_count[b] += 1
            is_trusted_by[a].add(b)

        for i in range(1, n + 1):
            if trust_count[i] == n - 1 and not is_trusted_by[i]:
                return i

        return -1

        