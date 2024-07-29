#In solving the problem of finding the town judge, I used a two-step approach to identify a potential candidate who is trusted by everyone else and trusts no one. First, I initialized sets for potential candidates and those who cannot be the judge, along with an array to count trust occurrences. As I iterated through the list of trust relationships, I updated the trust count and tracked individuals who are not candidates due to their role as trustors. After processing the trust data, I filtered out candidates who are in the anti_candidates set, leaving only those who are trusted by everyone else but trust no one. Finally, if there's exactly one such candidate left, that person is the judge; otherwise, there is no judge. The space complexity of this solution is O(n) due to the storage of trust counts and sets, and the time complexity is O(m + n), where m is the number of trust relationships and n is the number of people.

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1:
            return 1
        candidates = set()
        anti_candidates = set()
        trust_counter = [0] * n
        for t, t1 in trust:
            trust_counter[t1-1] += 1
            anti_candidates.add(t)
            if trust_counter[t1-1] == n-1:
                candidates.add(t1)
        candidates = candidates.difference(anti_candidates)
        return candidates.pop() if candidates else -1