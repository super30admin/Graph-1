# Time and Space complexity = O(V+E) & O(V)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # Create an array to keep track of the in-degrees for each person, initialized to 0
        indegrees = [0] * n
        
        # Iterate through the trust relationships
        for tr in trust:
            # Decrease the in-degree of the person who trusts (out-degree) by 1
            indegrees[tr[0] - 1] -= 1
            # Increase the in-degree of the person trusted (in-degree) by 1
            indegrees[tr[1] - 1] += 1
        
        # Find the person with in-degree equals n-1 (everyone trusts the judge, and judge trusts nobody)
        for i in range(len(indegrees)):
            if indegrees[i] == n - 1:
                # Return the person's label (index + 1) since the labels are from 1 to n
                return i + 1
        
        # If no judge is found (no one with in-degree equals n-1), return -1
        return -1
