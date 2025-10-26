'''
Solution : In-Degrees array
    For a relationship a-->Trusts-->b
        - +1 for b
        - -1 for a 
    At the end, if in_degrees of a person == n-1, we found the judge
Time Complexity: O(N) 
Space Complexity: O(N) 
'''
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        in_degrees = [0]*n 

        for relationship in trust:
            a = relationship[0]
            b = relationship[1]
            
            # a trusts b (people are 1->n indexed)
            in_degrees[b-1]+=1 # increse count of people trusting b
            in_degrees[a-1]-=1 # decrease count of 'a' as it's trusting someone
        
        for person_label in range(len(in_degrees)):
            if in_degrees[person_label]==n-1: # n-1 people trusting and this person not trusting anyone else
                return person_label+1 # Found judge. 
        
        return -1 # No Judge
            