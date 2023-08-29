# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        result = [0] * (n + 1)  # Initialize a list to keep track of trust count
        
        for tr in trust:
            result[tr[0]] -= 1
            result[tr[1]] += 1
        
        for i in range(1, n + 1):
            if result[i] == n - 1:
                return i
        
        return -1  # No judge found

