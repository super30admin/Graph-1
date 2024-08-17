class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:

        if trust == [] :
            if n == 1:
                return 1
            return -1

        inbound = [0 for _ in range(n+1)]

        for tr in trust :
            inbound[tr[1]] += 1
            inbound[tr[0]] -= 1

        print(inbound)
        for bound in inbound:
            if bound == n-1 :
                return inbound.index(bound)

        return -1

