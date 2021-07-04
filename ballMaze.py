"""
Time Complexity : hasPath_dfs - O(mn)
                  hasPath_bfs - O(mn)
Space Complexity : hasPath_dfs - O(1) [O(mn) - stack space]
                  hasPath_bfs - O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""
from queue import Queue

class Solution:
    def __init__(self):
        self.dirs = [[0,-1], [0, 1], [-1, 0], [1, 0]]
        self.m = 0
        self.n = 0
    
    def hasPath_dfs(self, maze, start, destination):
        if not maze or len(maze) == 0:
            return False
        self.m = len(maze)
        self.n = len(maze[0])
        
        return self.dfs(maze, start, destination)
    
    def dfs(self, maze, start, destination):
        i, j = start[0], start[1]
        maze[i][j] = 2
    
        # base case
        if i == destination[0] and j == destination[1]:
            return True
        
        # logic
        for d in self.dirs:
            r = i + d[0]
            c = j + d[1]
            while r > 0 and r < self.m and c > 0 and c < self.n and maze[r][c] != 1:
                r += d[0]
                c += d[1]
                
            # bring back ball
            r -= d[0]
            c -= d[1]
            
            if maze[r][c] != 2 and self.dfs(maze, [r, c], destination):
                return True
            
        return False
    
    def hasPath_bfs(self, maze, start, destination):
        if not maze or len(maze) == 0:
            return False
        self.m = len(maze)
        self.n = len(maze[0])
        q = Queue()
        q.put(start)
        maze[start[0]][start[1]] = 2
        
        while not q.empty():
            curr = q.get()
            for d in self.dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                while r > 0 and r < self.m and c > 0 and c < self.n and maze[r][c] != 1:
                    r += d[0]
                    c += d[1]
                
                # bring back the ball
                r -= d[0]
                c -= d[1]
                
                if r == destination[0] and c == destination[1]:
                    return True
                
                if maze[r][c] != 2:
                    q.put([r, c])
                    maze[r][c] = 2
                    
        return False
        
s = Solution()
print(s.hasPath_dfs([[0,0,1,0,0],
                 [0,0,0,0,0],
                 [0,0,0,1,0],
                 [1,1,0,1,1],
                 [0,0,0,0,0]], [0,4], [4,4]))
print(s.hasPath_bfs([[0,0,1,0,0],
                 [0,0,0,0,0],
                 [0,0,0,1,0],
                 [1,1,0,1,1],
                 [0,0,0,0,0]], [0,4], [4,4]))
                
            
            
                
        