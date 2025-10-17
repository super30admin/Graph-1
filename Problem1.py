"""
TC: O(T plus N) The time complexity is dominated by iterating through the 'trust' list (T is the length of 'trust') and iterating through the 'inDegree' array (N is the number of people).
SC: O(N) The space complexity is linear due to the auxiliary 'inDegree' array of size N plus 1 used to track the net trust score for each person.

Approach:

This problem is solved by using an In-Degree and Out-Degree count, represented by a single array, to efficiently identify the Town Judge. The Town Judge must satisfy two conditions: 1) The Judge trusts nobody (out-degree is 0), and 2) Everybody else trusts the Judge (in-degree is N-1).

1.  Net Trust Score: We use an array, inDegree of size N plus 1, to calculate the net trust score for each person. For every trust relationship [a, b] in the trust list: The giver a is recorded as trusting someone else (out-degree contribution), so we decrement their score by 1. The taker b is recorded as being trusted by someone (in-degree contribution), so we increment their score by 1.
2.  Judge Identification: After processing all trust relationships, the net trust score for a person i is inDegree[i] equals (in-degree of i) minus (out-degree of i). If person i is the Judge, their out-degree is 0, and their in-degree is N-1. Therefore, the Judge's net score must be (N-1) minus 0 equals N-1.
3.  Result: We iterate through the inDegree array from 1 to N. The first person found with a net score of N-1 is the Town Judge and is returned. If no such person exists, we return -1.

The problem ran successfully on LeetCode.
"""
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        inDegree = [0]*(n+1)

        for giver, taker in trust:
            inDegree[giver] -= 1
            inDegree[taker] += 1
        
        for i in range(1, n+1):
            if inDegree[i] == n-1:
                return i
        
        return -1