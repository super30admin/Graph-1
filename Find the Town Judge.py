# Time complexity: O(m+n)
# Space complexity: O(n)
# Approach: create an array of size n to store values of incoming and outgoing edges
# decrement the value of list[0] in array to note that its a truster and not being trusted
# decrement the value of list[1] in array to note that its trusted.
# return the value of index that is supported by all and doesn't support anyone.
# That is return the index that has value of n-1
# since we building the array of size n, the array would be 0 indexed, hence return array index +1


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 0:
            return -1
        indegrees = [0]*n
        for num in trust:
            indegrees[num[0]-1] -=1
            indegrees[num[1]-1] +=1
        for i in range(n):
            if indegrees[i] == n-1:
                return i+1
        return -1
        
        
        