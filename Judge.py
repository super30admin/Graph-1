"""
Approach:
- Maintain an array `n_degrees` where:
    - Decrease trust score for people who trust others.
    - Increase trust score for people who are trusted.
- A person will be the judge if:
    - They trust no one => trust out-degree = 0
    - Everyone else trusts them => trust in-degree = n - 1
- Final score of a judge = +n-1 (trusted by others) - 0 (trusts no one) = n-1

Time Complexity: O(t + n), where t = len(trust), n = number of people
Space Complexity: O(n)
"""
class Solution:
    def findJudge(self, n, trust):
        n_degrees = [0] * (n+1)
        for k, v in trust:
            n_degrees[k] -= 1
            n_degrees[v] += 1
        for i in range(1, len(n_degrees)):
            if n_degrees[i] == n - 1:
                return i
        return -1

def main():
    sol = Solution()
    test_cases = [
        (2, [[1, 2]], 2),
        (3, [[1, 3], [2, 3]], 3),
        (3, [[1, 3], [2, 3], [3, 1]], -1),
        (1, [], 1),  # single person is the judge
        (3, [[1, 2], [2, 3]], -1)
    ]

    for n, trust, expected in test_cases:
        result = sol.findJudge(n, trust)
        print(f"n={n}, trust={trust} => Output: {result} | Expected: {expected} | {'PASS' if result == expected else 'FAIL'}")


if __name__ == "__main__":
    main()
