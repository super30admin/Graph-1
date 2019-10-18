# Time Complexity : O(R) (Where R is length of trust)
# Space Complexity : O(p) (Where p is no of people)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Basically we need to find node (Judge) that does not have any outgoing edges and also it has incoming edges from all other people.
# - Iterate over trust array and store incoming and outgoing edges for each person.
# - Now itereate over each person to see if person fulfill over two condition. If any person fulfill the given condition return that person's index or in the end return -1.
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
#       Initialize person array with two spots for each person to store incoming and outgoing edges.
        people = [[0,0] for _ in range(N + 1)]
        
#       Iterate over trust and update no of incoming and outgoing edges for each person.
        for pair in trust:
            people[pair[0]][0] += 1
            people[pair[1]][1] += 1
            
#       Itearte over person to see if incoming edges is 0 or not
        for i in range(1, len(people)):
            if people[i][0] == 0:
#               If incoming edges is 0 check outgoinng edge
                if people[i][1] == N - 1:
                    return i
#       In the end return -1.
        return -1
