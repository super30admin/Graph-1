class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        # base case
        if len(trust) == 0:
            if N == 1:  # case when  1 is
                return 1
            else:
                return -1
        # variables
        t = [False for i in range(N)]  # array to check for items which trust anyone
        trust_s1 = [0 for i in range(N)]  # array to check the count of people who trust each person
        # logic
        for i in range(len(trust)):
            trust_s1[trust[i][1] - 1] += 1
            t[trust[i][0] - 1] = True

        # return
        for i in range(N):
            if t[i] == False and trust_s1[i] == N - 1:
                return i + 1
        return -1
