#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        incoming=[0]*(n)
        outgoing=[0]*(n)
        for node in trust:
                outgoing[node[0]-1]=outgoing[node[0]-1]+1
                incoming[node[1]-1]=incoming[node[1]-1]+1
        print(outgoing)
        print(incoming)
        for i in range(len(outgoing)):
            if outgoing[i]==0 and incoming[i]==n-1:
                return i+1
        return -1