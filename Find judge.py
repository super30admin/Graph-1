class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        main = [0 for i in range(N+1)]
        for a,b in trust:
            main[a]+=1
            main[b]-=1

        for i in range(1, N+1):
            if main[i] == -N+1:
                return i
        return -1
    Time: O(N)
    Space: O(N)
