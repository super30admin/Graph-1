class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        array_track = [0 for i in range(n+1)]

        if n == 1:
            return 1

        for v in trust:
            array_track[v[0]] -=1
            array_track[v[1]] +=1

        for i in range(len(array_track)):
            if array_track[i] == (n-1):
                return i

        return -1