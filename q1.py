# Time Complexity : O(n+m), Where m is number of elements in the trust list 
# Space Complexity : O(n), Where n is the input given
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        in_and_out_degree=[(None if(i==0) else 0)for i in range(n+1)]
        #print(in_and_out_degree)
        for i in trust:
            in_and_out_degree[i[0]]-=1#This will be outgoing edge for i[0]
            in_and_out_degree[i[1]]+=1#This will be inmcoming edge for i[1]
        #print(in_and_out_degree)
        
        for i in range(1,n+1):
            if(in_and_out_degree[i]==n-1):
                return i
        return -1
        