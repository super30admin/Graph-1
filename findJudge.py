class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        '''
        Inegree of town judge = n-1 
        outdegree of town judge = 0 
        There cannot be more than one town judge : If there were two town judges, then they would have to trust each other, otherwise we'd have a town judge not trusted by everybody. But this doesn't work, because town judges aren't supposed to trust anybody. Therefore, we know there can be at most one town judge.
        
        Brute force - using 2 dictionaries for indegree and out degree 
        
        Optimal solution - using just one dictioanry and reducing the count and increasing the count as per element for each traversal. 
        Time Complexity = O(N)
        Space Complexity = O(N)
        '''
        if n == 1:
            return 1
        indegree = collections.defaultdict(int)
        for i , j in trust:
            indegree[j] += 1
            indegree[i] -= 1
        for i in indegree:
            if indegree[i] == n-1:
                return i
        return -1
        
        
        
