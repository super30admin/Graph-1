# This can be done using Hashmap or array
# Im doing this using arrays. we need to keep track of the indegrees and outdegrees.
# Instead of using 2 arrays for indegrees and outdegrees we can just do it using a single array
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:

        if n == 1 and trust == []:
            return 1
        degrees = [0] * (n + 1)

        for [a, b] in trust:
            degrees[a] -= 1
            degrees[b] += 1

        for i in range(n + 1):
            if degrees[i] == n - 1:
                return i

        return -1
