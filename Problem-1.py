#Time Complexity :o(V+E)
#Space Complexity :o(V+E)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        if(len(trust)<N-1):
            return -1
        
        arr=[0]*(N+1)
        
        for i in range(0,len(trust)):
            curr=trust[i]
            arr[curr[0]]-=1
            arr[curr[1]]+=1
        
        for i in range(1,len(arr)):
            if(arr[i]==N-1):
                return i
        return -1
            