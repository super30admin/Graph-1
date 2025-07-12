TimeComplexity:O(n+t)
SpaceCompelxity:O(n)
Approach:this is a graph problem where both incoming and outing dergress mateer ..we need to find perosn where everyone trusts but they dont trust anyone:
if a trusts b val for b increses by 1 and val for a dec by1



class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        trust_list=[0 for i in range(n+1)]
        if len(trust)==0 and  n==1:return 1
        for t in trust:
            trust_list[t[1]]+=1
            trust_list[t[0]]-=1
        for people in range(len(trust_list)):
            if trust_list[people]==n-1:return people
        return -1
