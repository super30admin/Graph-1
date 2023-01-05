#TC: O(V + E)
#SC: O(V)

#Accepted on Leetcode

#Approach
#Create an array 0 to n-1 (inclusive) -> 
#for each 'trust-link' subtract one (from i[trusterIndex-1] - indicating an outgoing edge) and add one (to i[trustedIndex - 1] - indicating an incoming edge)
#Go over our created arr -> If val on any index == n - 1 we know it is the solution as that means the person trusts no one and is trusted by everyone (judge)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1:
            return 1
        #create an array 0 to n-1 (inclusive) -> for each 'trust-link' subtract one (from i[trusterIndex-1] - indicating an outgoing edge) and add one (to i[trustedIndex - 1] - indicating an incoming edge)

        trustArr = [0 for i in range(n)]
        for trustLink in trust:
            truster = trustLink[0] - 1
            trusted = trustLink[1] - 1
            trustArr[truster] -= 1
            trustArr[trusted] += 1

        for personIndex,trustVal in enumerate(trustArr):
            if trustVal == n-1:
                return personIndex + 1

        return -1 