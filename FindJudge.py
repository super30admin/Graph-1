#All TC on leetcode passed


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:

        #Here we create an array to hold the indegree and outdegree of each person. If a trusts b the we decrement a's trustdegree by 1 and increment b's trust degree by 1. At the end person who has trust degree n-1 is returned.
        #Time complexity - O(n)
        #Space complexity - O(n) - to store trust degree
        trustCount = [0]*n
        
        for a, b in (trust):
            print(a,b)
            trustCount[a-1]-=1
            trustCount[b-1]+=1

        for i, t in enumerate(trustCount):
            if t==n-1:
                return i+1
        return -1


