# Time Complexity: O(n) where n is the number of edges in adjacency list
# Space Complexity: O(n) where n is the number of edges in the adjacency list
# Approach: Do set difference between adjacency list keys and all nodes. Check if length is 1 and get possible judge
#			Get all nodes that trust possible judge and do set difference 
from collections import defaultdict
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        graph = defaultdict(list)
        for i in trust:
            graph[i[0]].append(i[1])
            
        all_nodes = set(range(1,N+1))
        possible_judge = all_nodes.difference(set(graph.keys()))
        if len(possible_judge) != 1:
            return -1
        possible_judge = possible_judge.pop()
        
        
        trusters = set()
        for node,val in graph.items():
            if possible_judge in val:
                trusters.add(node)
              
        judge_trusters = all_nodes.difference(trusters)
        if len(judge_trusters) == 1:
            return possible_judge
        
        return -1