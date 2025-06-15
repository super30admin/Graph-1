# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Approach:
# 1. Use BFS to traverse the maze.
# 2. For each cell, move in all four directions until hitting a wall.
# 3. If the destination is reached, return True.
# 4. If all possible paths are explored and the destination is not reached, return False.
from collections import deque
class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        m = len(maze)
        n = len(maze[0])
        q = deque()
        q.append(start)
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]

        while q:
            cell = q.pop()
            for row, col in dirs:
                r = cell[0] + row
                c = cell[1] + col

                while r >= 0 and c >= 0 and r < m and c < n and maze[r][c] != 1:
                    r += row
                    c += col
                r -= row
                c -= col

                if r == destination[0] and c == destination[1]:
                    return True

                if maze[r][c] != -1:
                    q.append([r,c])
                    maze[r][c] = -1
        return False

# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# # Approach:
# 1. Use DFS to traverse the maze.
# 2. For each cell, move in all four directions until hitting a wall.
# 3. If the destination is reached during traversal, start returning True.
# 4. If all possible paths are explored and the destination is not reached, return False.   
class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        m = len(maze)
        n = len(maze[0])
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]

        def dfs(i, j):
            if i == destination[0] and j == destination[1]:
                return True

            if maze[i][j] == -1:
                return False

            maze[i][j] = -1

            for row, col in dirs:
                r = i + row
                c = j + col
                while r >= 0 and c >= 0 and r < m and c < n and maze[r][c] != 1:
                    r += row
                    c += col
                if dfs(r-row, c-col):
                    return True
            return False

        return dfs(start[0], start[1])