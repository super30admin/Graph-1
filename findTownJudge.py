# Time Complexity: O(n) where n is the number of edges in adjacency list
# Space Complexity: O(n) where n is the number of edges in the adjacency list
# Approach: Do set difference between first node of all edges and all nodes. Check if length is 1 and get possible judge
#			Get all nodes that trust possible judge and do set difference 
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trusters = set()
        judge_trusters = set()
        
        for i in trust:
            trusters.add(i[0])
            
        all_people = set(range(1,N+1))
        possible_judge = all_people.difference(trusters)
        if len(possible_judge) != 1:
            return -1
        possible_judge = possible_judge.pop()
        
        for i in trust:
            if i[1] == possible_judge:
                judge_trusters.add(i[0])
            
        non_trusters = all_people.difference(judge_trusters)
        
        if len(non_trusters) == 1:
            return possible_judge
        
        return -1