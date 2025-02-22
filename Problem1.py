'''
1. We need to keep track of incoming and outgoing connections of the people.
2. If a person 1 trusts 2, then incoming connections to 2 is one and outgoing would be 0.
3. So to satify conditions to become a judge, c1: outgoing conns = 0 c2: incoming conns = n-1
4. We can take this one step ahead by using a single array and checking sum of both incoming and outgoing to be equal to n-1.
 We can do this by making an outgoing conn as a negation to input conn.

TC: O(n)
SC: O(n) -> Array (n persons)
'''

from typing import List

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1 and not trust:  
            return 1
        
        trustCount = [0] * (n + 1)

        for a, b in trust:
            trustCount[a] -= 1  
            trustCount[b] += 1  
        
        for person in range(1, n + 1):
            if trustCount[person] == n - 1:
                return person
        
        return -1  
        

        
        




