# Time Complexity : O(m * n) , m rows and n columns
# Space Complexity : O(m * n) 

from typing import List

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or not maze[0]:
            return False

        rows, cols = len(maze), len(maze[0])
        visited = [[False] * cols for _ in range(rows)]
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        return self.dfs(maze, start, destination, visited, directions)

    def dfs(self, maze: List[List[int]], curr: List[int], destination: List[int], visited: List[List[bool]], directions: List[List[int]]) -> bool:
        if curr == destination:
            return True

        x, y = curr[0], curr[1]
        visited[x][y] = True

        for dx, dy in directions:
            nx, ny = x, y

            while 0 <= nx + dx < len(maze) and 0 <= ny + dy < len(maze[0]) and maze[nx + dx][ny + dy] != 1:
                nx += dx
                ny += dy

            if not visited[nx][ny] and self.dfs(maze, [nx, ny], destination, visited, directions):
                return True

        return False
