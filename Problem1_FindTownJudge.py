'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 997. Find the Town Judge


# https://leetcode.com/problems/find-the-town-judge/

#-----------------
# Time Complexity: 
#-----------------
# O(V + E): V is the number of people, E is the number of relationships (edges)
#           between those people
#------------------
# Space Complexity: 
#------------------
# O(V) - Stack holds max V items (number of people in the town)

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegrees = [0 for i in range(n)]
        
        for t in trust:
            indegrees[t[1] - 1] += 1
            indegrees[t[0] - 1] -= 1
        
        for i in range(len(indegrees)):
            if indegrees[i] == n-1:
                return i + 1
        
        return -1