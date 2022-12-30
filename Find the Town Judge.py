import numpy as np
from collections import defaultdict
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # Bruteforce
        if n == 1:
            return 1

        first = set()
        second = set()
        count = defaultdict(int)
        label = -1

        for i in trust:
            first.add(i[0])
            second.add(i[1])
            count[i[1]] += 1 

        for i in second:
            if i not in first and count[i] == n-1:
                label = i

        return label

        # Graph (using incoming and outgoing edges)
        if n == 1:
            return 1
        netEdges = np.zeros(n)
        label = -1

        for x, y in trust:
            netEdges[x-1] = netEdges[x-1] - 1
            netEdges[y-1] = netEdges[y-1] + 1
            if netEdges[y-1] == n-1:
                label = y
        if netEdges[label - 1] == n - 1:
            return label
        return -1
