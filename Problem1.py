class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        # Time Complexity : O(n + m) where n is the value N and m is the size of trust list.
        # Space Complexity : O(N) because we are storing all the elements in the dictionary
        person_dict = dict()
        for i in range(1, N+1):
            person_dict[i] = [0, 0]
        for i in trust:
            person_dict[i[1]][0] += 1
            person_dict[i[0]][1] += 1
        for key, val in person_dict.items():
            if val[0] == N - 1 and val[1] == 0:
                return key
        return -1