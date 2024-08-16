# Time Complexity : O(N)
# Space Complexity : Confused between O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:

        # BRUTE FORCE APPROACH
        #         if N == 1:
        #             return 1
        #         if len(trust) == 1:
        #             return trust[0][1]
        #         keys = set()
        #         values = []

        # Separating keys and values in different arrays
        #         for tup in trust:
        #             keys.add(tup[0])
        #             values+=[tup[1]]

        #         val_set = set(values)
        # Calculated occyrances of each element in the values array
        #         cc = collections.Counter(values)
        #         unique = []
        # for each element in values if it is not in keys and its number of occurances is equal to that of keys
        #         for n in val_set:
        #             if n not in keys:
        #                 if cc[n] == len(keys):
        #                     unique.append(n)
        # if there is only one such element then return the number else -1
        #         if len(unique) == 1:
        #             return unique[0]
        #         return -1

        # GRAPH APPROACH

        # for the town judge the number of ingress - outgres will be equal to N-1
        if N == 1:
            return 1
        # count will have ingress - ougtgess for each of the number
        count = [0] * (N + 1)
        for tup in trust:
            count[tup[0]] -= 1
            count[tup[1]] += 1

        # iterate over all the numbers, if the ingress- outgress = N-1 then that is the answer
        for i in range(N + 1):
            if count[i] == N - 1:
                return i
        return -1