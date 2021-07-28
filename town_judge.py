# TC: O(n)
# SC: O(n)
class Solution:
    def findJudge(self, n, trust):
        #         Base condition
        if n == 1:
            return 1
        #         define for score track
        arr = [0] * (n + 1)

        #       Iterate over lists and decrease 1 st value and increase 2nd
        for i in trust:
            a = i[0]
            b = i[1]
            arr[a] -= 1
            arr[b] += 1
        # After the end of the loop if any values score is n-1 that is all except
        # itself we will return that else we will return -1 in the end
        for i in range(1, n + 1):

            if arr[i] == n - 1:
                return i
        return -1
