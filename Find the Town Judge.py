# Graph
# TC: O(N)
# SC: O(N)
# Yes, It ran on Leetcode
# No problems

import collections
class Solution:
    def findJudge(self, N: int, trust) -> int:
        
        adj_list = collections.defaultdict(list)
        for link in trust:
            adj_list[link[0]].append(link[1])
        
        backward = collections.defaultdict(list)
        for link in trust:
            backward[link[1]].append(link[0])
            
        for i in range(1,N+1):
            if i not in adj_list and len(backward[i])==N-1:
                return i
        return -1
            
            