"""
Problem2 The Maze (https://leetcode.com/problems/the-maze/)

"""

# Approach - 1

import collections
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        """
        using BFS
        TC: O(M * N) M=rows; N = cols
        SC: O(M + N)
        """
        m = len(maze)
        n = len(maze[0])
        if start[0] == destination[0] and start[1] == destination[1]: return True
        dirs = [(0, 1),(1, 0),(-1, 0),(0, -1)]
        
        q = deque()
        q.append((start[0], start[1]))
        maze[start[0]][start[1]] = 2
        
        while q :
            row, col = q.popleft()
            
            for d in dirs:
                i,j = row, col
                while i >= 0 and i < m and j >=0 and j < n and maze[i][j] != 1:
                    i = i + d[0]
                    j = j + d[1]
                i  = i - d[0]
                j = j - d[1]

                if maze[i][j] != 2:
                    if i == destination[0] and j == destination[1]: return True
                    q.append((i, j))
                    
                    maze[i][j] = 2
                        
                        
        return False
                        

# Approach - 2

import collections
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        """
        TC: O(M * N)
        SC: O(M * N)
        """
        m = len(maze)
        n = len(maze[0])
        if start[0] == destination[0] and start[1] == destination[1]: return True
        dirs = [(0, 1),(1, 0),(-1, 0),(0, -1)]
        
        def helper_dfs(maze, start, stop):
            # Base Case
            if start[0] == stop[0] and start[1] == stop[1]: return True
            if maze[start[0]][start[1]] == 2: return False
            
            # Logic
            maze[start[0]][start[1]] = 2
            for d in dirs:
                i , j= start[0], start[1]
                while i >= 0 and i < m and j >=0 and j < n and maze[i][j] != 1:
                    i = i + d[0]
                    j = j + d[1]
                i  = i - d[0]
                j = j - d[1]
                if (helper_dfs(maze, list([i, j]), stop)): return True
                
            return False
    
        return helper_dfs(maze, start, destination) 
        

                        
                        
                
                
                
        
        
        
        