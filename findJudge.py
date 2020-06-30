# TC:O(m+n),where n is the value N and m is the size of trust list.
# SC:O(n),because we are storing all the elements in the set


# Approach:Create a set of to store who trusts whom.
#For each pair in trust list, add the a to v set-
#increment the count for b in the pair.
#if the count of the person in set exists and is equal to length n-1, return his label, else retrun -1
        
class Solution:
    def findJudge(self, n: int, t: List[List[int]]) -> int:
        v=set()
        d=[0 for i in range(n+1)]
        if n==1:
            return 1
        ma=0;ma_i=0
        for a,b in t:
            v.add(a)
            d[b]+=1
            if ma<d[b]:
                ma=d[b]
                ma_i=b
        if ma_i not in v and ma==n-1:
            return ma_i
        return -1
        
