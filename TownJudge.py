# Time complexity: O(n)
# Space: O(n)
# The intuition is to determine the indegress vs the outdegress for each and every element in the trust array. After that find if any individual/element value is n-1 meaning it is trusted by everybody but it doesn't trust nobody
# Then return the index otherwise return -1

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        arr = [0] * (n+1)
        for ai, bi in trust:
            arr[ai] -= 1
            arr[bi] += 1
        
        for i in range(1, len(arr)):
            if arr[i] == n - 1:
                return i
        return -1
