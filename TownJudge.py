#997. Find the Town Judge
"""
Time Complexity : O(n)
Space Complexity : O(2*n)

Make graph out of trust array.
According to question, a person is town judge if he has no outgoing(trusts no body)
and incoming is n - 1 (trusted by every other person)

maintained two dict() to do that calculation
"""
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        outgoing = dict()
        incoming = dict()
        
        for i in range(1, n+1):
            outgoing.update({i : 0})
            incoming.update({i : 0})
        
        for i in trust:
            outgoing.update({i[0] : 1})
            incoming.update({i[1] : incoming.get(i[1]) + 1})
            
        print(outgoing)
        print(incoming)
        
        for i in outgoing:
            if outgoing[i] == 0 and incoming[i] == n-1:
                return i
        
        return -1
