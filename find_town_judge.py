class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        # #O(v+e)
        # #O(v+e)
        # #indegree=n-1 and outdegree=0
        # if N == 1: return 1
        # #make separate arrays
        # arr1 = [c[0] for c in trust]
        # arr2 = [c[1] for c in trust]
        # #people trusting judge ==(n-1) and judge should trust nobody
        # for c in arr2:
        #     if c not in arr1 and arr2.count(c) == (N - 1):
        #         return c
        # return -1
        
        #O(v+e)
        #O(v)> just different people
        indegree=[0]*N
               #people truuting others, their trust value reduces and people who are trusted their trust value increases
            #index starts from 0 in indegree but N starts from 1
        for pair in trust:
            indegree[pair[0]-1]-=1
            indegree[pair[1]-1]+=1
        print indegree
        #if indegree equals N-1 for any person> thats the answer
        for value in range(N):
            if indegree[value]==N-1:
                return value+1
        return -1