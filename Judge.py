#Time Complexity: O(V+E) =>O(n+len(trust))
#Space Complexity: O(n)
#Solved using in-degrees method. If a trusts b, decrement the degree for a and increment the degree for b
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        degrees_array=[0 for i in range(n)]
        for t in trust:
        	#3 is stored in index 2
            degrees_array[t[0]-1]=degrees_array[t[0]-1]-1
            degrees_array[t[1]-1]=degrees_array[t[1]-1]+1
        for i in range(len(degrees_array)):
            if degrees_array[i]==n-1:
                return i+1
        return -1