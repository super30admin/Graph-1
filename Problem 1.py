# Time:O(n)
# Space: O(n)
class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        if n == 1 and len(trust) == 0:
            return 1
        dic1 = {}
        dic2 = {}
        for tr in trust:
            if tr[1] not in dic1:
                dic1[tr[1]] = 1
            else:
                dic1[tr[1]] += 1
            if tr[0] not in dic2:
                dic2[tr[0]] = 1
            else:
                dic2[tr[0]] += 1
        for i in range(1, n+1):
            if i in dic1 and dic1[i] == n-1 and i not in dic2:
                return i
        return -1
        
