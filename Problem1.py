class Solution:
    def findJudge1(self, N: int, trust: List[List[int]]) -> int:
        # Time Complexity : O(n + m) where n is the value N and m is the size of trust list.
        # Space Complexity : O(N) because we are storing all the elements in the dictionary
        # Accepted on leetcode
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

    def findJudge2(self, N, trust):
        # Time Complexity : O(m + N) where m is the size of trust array and N is the number of nodes in the graph
        # Space Complexity : O(N) to store all the inwards and outgoing arrows for each node
        # Accepted on leetcode
        # Same time and space as above in leetcode
        if N == 1:
            return 1
        res = [0] * (N+1)
        for i in trust:
            res[i[0]] -= 1
            res[i[1]] += 1
        for index, val in enumerate(res):
            if val == N - 1:
                return index
        return -1