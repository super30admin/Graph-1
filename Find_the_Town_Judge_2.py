# Created by Aashish Adhikari at 2:16 PM 4/7/2021

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

        # logic: make use of in-degrees and out-degrees
        nett_degree = [0 for person in range(N+1)] # VVI to do N+1 here

        for idx in range(0, len(trust)):

            nett_degree[trust[idx][0]] -= 1
            nett_degree[trust[idx][1]] += 1


        for idxx in range(1, len(nett_degree)):

            if nett_degree[idxx] == N-1:
                return idxx
        return -1
