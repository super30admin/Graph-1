"""
FAANMG Problem #115 {Easy} 

997. Find the Town Judge

# TC: O(V+E)
# SC: O(V) = O(n)


Did this code successfully run on Leetcode : Yes


@name: Rahul Govindkumar
"""

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
         # Initialize an array to keep track of trust counts for each person
        trust_count = [0] * (n + 1)
        # Iterate through the trust array
        for i, j in trust:
            # Decrement trust count for person i (who trusts someone else)
            trust_count[i] -= 1
            # Increment trust count for person j (who is trusted by someone else)
            trust_count[j] += 1
        # Iterate through the people
        for i in range(1, n + 1):
            # Check if the trust count for a person is equal to n-1
            if trust_count[i] == n - 1:
                # If so, return the label of this person (the town judge)
                return i
        # If no town judge is found, return -1
        return -1   
