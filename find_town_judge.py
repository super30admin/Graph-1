"""
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Idea is that 
    we compute the set of values of the a nodes and b nodes
    b - set represent the prospective judge set
    Computing the difference of set will give the disjoint nodes from a and b
    if the set difference between b and a is greater than 1 or empty, return -1
    Else
        pop the value from the set
        if value is equal to (sum of all nodes having value) - 1  then return value
        else return -1

Alternative(Space Optimal with respect to overhead)
- Idea is to constrcut the incoming and outgoing array by incrementing the count
by 1 for a in incoming if in [a,b] and increment for b in in outgoing
- At the the end of the processing, iterate over the length of array and check
if incoming value  = 0 and outgoing = N-1 return that index
- return -1

"""

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        # if not trust:
        #     return N
        # a = [x[0] for x in trust]
        # b = [x[1] for x in trust]

        # #set difference - for getting town judge
        # c = set(b) - set(a)
        # if len(c) > 1 or not c:#violates the trust condition
        #     return -1
        
        # a = c.pop()
        # return a if sum(t[1] == a for t in trust) == N-1 else -1


        incoming_arr = [0] * (N + 1)
        outgoing_arr = [0] * (N + 1)

        for t in trust:
            incoming_arr[t[0]]+=1
            outgoing_arr[t[1]]+=1

        for i in range(len(1,N+1)):
            if incoming_arr[i] == 0 and outgoing_arr[i] == N - 1:
                return i
        return -1