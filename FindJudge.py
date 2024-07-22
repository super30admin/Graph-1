# Time Complexity : O(m+n), where m is the number of trust relations and n is the number of people
# Space Complexity : O(n)

class Solution:
    def findJudge(self, n, trust):
        if n == 0:
            return -1
        trustees = [0] * n

        for t in trust:
            trustees[t[0] - 1] -= 1  # Truster. Subtract
            trustees[t[1] - 1] += 1  # Trusted. Add

        for i in range(n):
            if trustees[i] == n - 1:  # Trusted by all, but trusts none
                return i + 1

        return -1

# Examples
sol = Solution()

# Example 1
n1 = 3
trust1 = [[1, 3], [2, 3]]
print("Example 1:", sol.findJudge(n1, trust1))  # Output: 3

# Example 2
n2 = 3
trust2 = [[1, 3], [2, 3], [3, 1]]
print("Example 2:", sol.findJudge(n2, trust2))  # Output: -1

# Example 3
n3 = 4
trust3 = [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]]
print("Example 3:", sol.findJudge(n3, trust3))  # Output: 3