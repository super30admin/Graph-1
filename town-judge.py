class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        # if len(trust)==0:
        #     return -1
        arr = [0] * N
        for i in trust:
            arr[i[0] - 1] -= 1
            arr[i[1] - 1] += 1

        for j in range(len(arr)):
            if arr[j] == N - 1:
                return j + 1
        return -1
    # O(v+e) s=O(N)