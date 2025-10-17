# Time Complexity : O(N + t) where N is the number of people and t is the number of trust relationships
# Space Complexity : O(N) as we are using two arrays of size N+1
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using two arrays to keep track of the in-degrees and out-degrees of each person.
# I am iterating through the trust list and for each trust relationship, I am incrementing
# the in-degree of the person being trusted and the out-degree of the person who trusts.
# Finally, I am checking for a person who has in-degree of n-1 and out-degree of 0.
# If such a person exists, I return their label, otherwise I return -1.

from typing import List
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        in_degree = [0] * (n+1)
        out_degree = [0] * (n+1)
        for i,j in trust:
            in_degree[j] += 1
            out_degree[i] += 1
        for i in range(1,n+1):
            if in_degree[i] == n -1 and out_degree[i] == 0:
                return i
        return -1
        