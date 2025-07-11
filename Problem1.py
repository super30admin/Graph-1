"""
I initialized a dictionary person_dict where each key is a person from 1 to n, and the value is a list [trusted_by_count, trusts_count]. This helps track how many people trust them, and how many people they trust. I then looped through the trust list. For each [a, b], it means person a trusts person b. So I incremented b's trusted_by_count and a's trusts_count. Finally, I looped through person_dict to find the person who is trusted by n-1 others and trusts no one. If such a person is found, I return their label; otherwise, I return -1.
Time Complexity: O(m+n)
Space Compelxity: O(n)
"""
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:

        person_dict = {}

        for i in range(1, n+1):
            person_dict[i] = [0, 0]

        for i in trust:

            person_dict[i[1]][0] += 1
            person_dict[i[0]][1] += 1

        for key, val in person_dict.items():
            if val[0] == n - 1 and val[1] == 0:
                return key
        return -1 