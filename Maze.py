# BFS
# TC: O(mn)
# SC: O(mn) better- can be stopped early if destination found at earlier levels
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze: return False
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        m, n = len(maze), len(maze[0])
        q = deque()
        # append start point
        q.append((start[0], start[1]))
        # mark visited to avoid revisits
        maze[start[0]] [start[1]] = 2
        
        while q:
            # ready to move
            curr = q.popleft()
            # if curr spot is destination ...
            if curr[0] == destination[0] and curr[1] == destination[1] : return True
            
            # move in all dirs if possible
            for d in dirs:
                i, j = curr[0], curr[1]
                # make a move only if boundary conditionsa satisfy and the cell is not wall
                while i>=0 and j>=0 and i<m and j<n and maze[i][j] != 1:
                    i += d[0]
                    j += d[1]
                # come back to the actual stoppage point
                i -= d[0]
                j -= d[1]
                # if this cell is not visited, append and consider for further progress
                if maze[i][j] != 2:
                    q.append((i,j))
                    maze[i][j] = 2
            
        return False
    
# DFS
# TC: O(mn)
# SC: O(mn)
class Solution:
    dirs = [(0,1),(0,-1),(1,0),(-1,0)]
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze: return False
        m, n = len(maze), len(maze[0])
        return self.dfs(maze, start, destination, m, n)
    
    def dfs(self, maze, start, destination, m, n):
        # base
        if start[0] == destination[0] and start[1] == destination[1]: return True
        if maze[start[0]][start[1]] == 2: return False

        # logic
        maze[start[0]][start[1]] = 2
        for d in self.dirs:
            i, j = start[0], start[1]
            while i>= 0 and j >=0 and i < m and j < n and maze[i][j] != 1:
                i += d[0]
                j += d[1]
            i-= d[0]
            j-= d[1]
            if self.dfs(maze, [i,j], destination, m ,n ): return True
        return False