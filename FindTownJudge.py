# Time Complexity  :
# O(V+E) , V = no. of people, E = trust relations

# Space Complexity  :  
# O(V) , V = no. of people


# Approach:
# Array manipulation based on given dependencies among nodes.


class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        if n==0:
            return -1

        # Create an array to keep track of inDegrees(person being trusted) and outDegrees(person trusting)
        trustDegrees = [0 for i in range(n)]

        for curr in trust:
            outgoing = curr[0]
            # for every outgoing, go to "outgoing-1" index in trustDegrees array, and reduce the count by 1
            trustDegrees[outgoing-1] -= 1

            incoming = curr[1]
            # for every incoming, go to "incoming-1" index in trustDegrees array, and increase the count by 1
            trustDegrees[incoming-1] += 1
        
        # finally , iterate through "trustDegrees", and find element having value = n-1, then return that idx+1
        for i in range(len(trustDegrees)):
            if trustDegrees[i] == n-1:
                return i+1
        
        return -1