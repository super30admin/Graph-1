# https://leetcode.com/problems/find-the-town-judge/
# Time Complexity-O(v+e) Space Complexity- O(v)

class Solution:
    def findJudge(self, n, trust):
        # create two arrays one for incoming and other for outgoing
        indegrees = [0] * (n + 1)
        outDegrees = [0] * (n + 1)

        # iterate through the trust array
        for tr in trust:
            # increase the number if outgoing
            outDegrees[tr[0]] += 1
            # increase the number if incoming
            indegrees[tr[1]] += 1

        # iterate through the range
        for i in range(1, n + 1):
            # check if the number is trusted by everyone except the current number
            if indegrees[i] == n - 1 and outDegrees[i] == 0:
                return i
        # return -1 if no town judge exist
        return -1


solution = Solution()
print(solution.findJudge(2,[[1,2]]))


            