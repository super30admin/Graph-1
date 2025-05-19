class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        """
        Approach:
        1. Use an array `trust_score` of size (n+1) to track net trust per person.
        2. For each trust pair (a, b):
           - Decrease trust_score[a] because a trusts someone → cannot be the judge.
           - Increase trust_score[b] because b is trusted by someone.
        3. After processing all trust pairs, the town judge (if exists) will have:
           trust_score[judge] == n - 1
           → trusted by everyone else, and trusts no one.
        4. Return the index of the person with score n - 1, or -1 if not found.

        Time Complexity: O(T + N), where T is the number of trust relationships and N is the number of people.
        Space Complexity: O(N), for storing the trust score of each person.
        """
        trust_score = [0] * (n + 1)  # 1-based indexing

        for a, b in trust:
            trust_score[a] -= 1  # a trusts someone → cannot be judge
            trust_score[b] += 1  # b is trusted

        for person in range(1, n + 1):
            if trust_score[person] == n - 1:
                return person

        return -1
