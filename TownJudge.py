class Solution(object):
    # tc. : O(V+E) other words O(n+m) where m is the len of the trust 
    # sc : O(n)
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        # two conditions to check
        # town judge does nto depend on any other node and all the other nodes should depend on the town judge
        # checking the indegrees of each node and if this node depends on other it strust value letsreduce it by 1 if other people trust this node lets increade the coutn by 1 
        # in the end the one with n-1 nodes trust is our judge

        trust_count = [0]*(n+1) # each node intially 0 members as its 1-indexed people n+1

        for relation in trust:
            trust_count[relation[0]] -= 1# as this ndoe is trustign other person reduce its count, our judge does not trust anyone
            trust_count[relation[1]] += 1

        for i in range(1,n+1):
            if trust_count[i] == n-1:
                return i 

        return -1

        

        