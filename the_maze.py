# Did this code successfully run on Leetcode : YES

# approach
# neighbors won't be immediate neighbors, instead they will be cells next to walls
# TC: O(M*N)
# SC: O(M*N)

# BFS

from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze), len(maze[0])
        q = deque([start])
        maze[start[0]][start[1]] = 2
        # dirs
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while q:
            [x, y] = q.popleft()
            # print((x, y))
            if [x, y] == destination:
                return True
            # get nearest walls
            # one less is index of closest 'neighbor'
            for dir in dirs:
                [i, j] = [x + dir[0], y + dir[1]]
                while 0 <= i < m and 0 <= j < n and maze[i][j] != 1:
                    i += dir[0]
                    j += dir[1]
                i -= dir[0]
                j -= dir[1]
                if maze[i][j] != 2:
                    maze[i][j] = 2
                    q.append([i, j])
        return False

# DFS

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze), len(maze[0])
        
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        def dfs(i, j):
            if maze[i][j] == 2:
                return False
            if [i, j] == destination:
                return True
            maze[i][j] = 2
            for dir in dirs:
                x, y = i, j
                while 0 <= x < m and 0 <= y < n and maze[x][y] != 1:
                    x += dir[0]
                    y += dir[1]
                x -= dir[0]
                y -= dir[1]
                if dfs(x, y):
                    return True
            return False
        
        return dfs(start[0], start[1])