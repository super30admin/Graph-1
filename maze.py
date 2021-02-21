"""
Time Complexity: O(m*n)
Space Complexity: O(m*n)
"""
# Breadth First Search
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze: return
        m = len(maze)
        n = len(maze[0])
        
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        q = deque()
        q.append(start)
        maze[start[0]][start[1]] = 2
        
        while q:
            curr = q.popleft() 
            if curr == destination: return True
            
            for d in dirs:
                r = curr[0]
                c = curr[1]
                while r>=0 and c>=0 and r<m and c<n and maze[r][c]!=1:
                    r += d[0]
                    c += d[1]
                r -= d[0]
                c -= d[1]
                if maze[r][c] != 2:
                    q.append([r,c])
                    maze[r][c] = 2
            
        return False
"""
Time Complexity: O(m*n)
Space Complexity: O(m*n)
"""
# Depth First Search
class Solution:
    dirs = [[0,1], [0,-1], [1,0], [-1,0]]
    
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if not maze: return
        self.m = len(maze)
        self.n = len(maze[0])
        
        return self.dfs(maze, start, destination)
        
    def dfs(self, maze, start, dest):
        # Base case
        if start == dest: return True
        if maze[start[0]][start[1]] == 2: return False
        
        # Logic
        maze[start[0]][start[1]] = 2
        for d in self.dirs:
            r, c = start[0], start[1]
            while r>=0 and c>=0 and r<self.m and c<self.n and maze[r][c] != 1:
                r += d[0]
                c += d[1]
            r -= d[0]
            c -= d[1]
            
            flag = self.dfs(maze, [r,c] ,dest)
            if flag: return True
            
        return False