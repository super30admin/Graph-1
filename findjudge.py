from typing import List
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # if trust is None or len(trust) == 0: return -1
        # trustarray = [0] * (n + 1)
        # for t in trust:
        #
        #     trustarray[t[1]] += 1
        # for idx in trustarray:
        #     print(trustarray[idx])
        #     if trustarray[idx] == n - 1:
        #         return idx
        # return -1
        indegrees = [0] * (n+1)

        for t in trust:
           # indegrees[t[0] - 1] -= 1
            indegrees[t[1]] += 1
        print(indegrees)
        for i in range(len(indegrees)):
            if indegrees[i] == n - 1:
                return i
        return -1

if __name__ == '__main__':
    print(Solution().findJudge(n=3,trust=[[[1,3],[2,3],[3,1]]]))