# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We iterate throught the trust list and keep track of the truster and trustee. Then we itereate through the trustee list 
and check if the trustee is trusted by everyone and not trusting anyone.
"""

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1: return 1
        if n == None or trust == None or len(trust) == 0: return -1
        truster_list = [0 for _ in range(n+1)]
        trustee_list = [0 for _ in range(n+1)]

        for truster, trustee in trust:
            truster_list[truster] += 1
            trustee_list[trustee] += 1

        for index in range(len(trustee_list)):
            if trustee_list[index] == n-1 and truster_list[index] == 0:
                return index
        return -1
