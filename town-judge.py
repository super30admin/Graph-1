# Time Complexity : O(V + E)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        if len(trust) < n - 1:
            return -1
        
        indegree = [0] * (n + 1) #no. of directed edges going into it
        outdegree = [0] * (n + 1) #no. of directed edges going out 
        
        # checking whether or not any of them meet the criteria of the town judge.
        for a, b in trust:
            outdegree[a] += 1
            indegree[b] += 1

        for i in range(1, n + 1):
            # if town judge has indegree n - 1 i.e. everybody trusts them
            # if town judge has outdegree 0 where they trust nobody
            if indegree[i] == n - 1 and outdegree[i] == 0:
                return i
        return -1