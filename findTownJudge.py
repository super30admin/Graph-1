#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N == 0:
            return -1

        trusts = [0] * (N)

        #get counts of people who trust and are trusted (-1 to trusts a person and +1 to the trusted person)
        for a, b in trust:
            trusts[a-1] -= 1
            trusts[b-1] += 1

        #check if there is anyone who everyone trusts
        for t in range(len(trusts)):
            if trusts[t] == N-1:
                return t+1

        return -1
