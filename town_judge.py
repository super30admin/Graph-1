# Time Complexity :
# O(N+M)  - N is number of people and M is size of the trust array

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We go through each element in the trust list. Whenever a person trusts someone, we reduce their trust count and when someone is trusted by someone else, we increase their trust count
#At the end we return the ID of the user who has a trust value equal to number of people
#If no such person exists, return -1

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        adjacency_map = {i+1:0 for i in range(0,n)}
        
        for elem in trust:
            adjacency_map[elem[0]] -= 1
            adjacency_map[elem[1]] += 1

        for key,values in adjacency_map.items():
            if values == n-1 :
                return key
        return -1
