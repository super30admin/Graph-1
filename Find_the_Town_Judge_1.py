# Created by Aashish Adhikari at 6:30 PM 4/6/2021

'''
Time Complexity:
O(n)

Space Complexity:
O(n)
'''

class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """

        if len(trust) == 0:
            if N == 1:
                return 1
            else:
                return -1

        hm = {}
        believer = set()

        for pair in trust:
            if pair[0] not in believer:
                believer.add(pair[0])

            if pair[1] not in hm:
                hm[pair[1]] = 1
            else:
                hm[pair[1]] += 1

        for key in hm:


            if hm[key] == N-1 and key not in believer:
                return key
        return -1