class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        #time complexity: O(V+E)
        # Space complexity: O(V)
        indegreeLi = [0 for x in xrange(n)]
        
        for i in xrange(len(trust)):
            # reducing when someone trusts and increasing when someone is trusted
            indegreeLi[trust[i][0]-1] -= 1
            indegreeLi[trust[i][1]-1] += 1
        
        for i in xrange(len(indegreeLi)):
            #person trusted by n-1 people is the judge
            if indegreeLi[i] == n-1:
                return i+1
        return -1
            
