"""
Approach:

goal is to check if there is a perfect 1 to 1 mapping of the chars. We use 2 hash maps in order to track 2 directional
mapping

1) store s to t mapping in hashmap 1
2) Store t to s mapping in hashmap 2
3) if s[i] exists already it should have been mapped to t[i] use HM-1 to check this
4) if t[i] exists already it should have been mapped to s[i] use HM-1 to check this

"""

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_to_t = {}
        t_to_s = {}

        for i, char in enumerate(s):
            if char not in s_to_t:
                s_to_t[char] = t[i]
            elif s_to_t[char] != t[i]:
                return False
            """if t[i] in t_to_s and t_to_s[t[i]] != char:
                    return False"""
            if t[i] not in t_to_s:
                t_to_s[t[i]] = char
            elif t_to_s[t[i]] != char:
                return False
        return True

"""
Time Complexity:O(n) where n is the number of chars in given string
Space Complexity: O(n)
"""