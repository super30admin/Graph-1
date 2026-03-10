# Time Complexity : O(m * n), worst case visiting all cells
# Space Complexity : O(m * n), visited matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use DFS to explore the maze. From a cell, roll in each direction until hitting a wall.
# 2. Only mark the stopping cell as visited and continue DFS from there.
# 3. If we reach the destination, return True. Otherwise, continue exploring other directions.
# 4. Return False if all paths have been explored.

from typing import List

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze), len(maze[0])
        visited = [[False] * n for _ in range(m)]
        
        def dfs(x, y):
            if [x, y] == destination:
                return True
            if visited[x][y]:
                return False
            visited[x][y] = True
            for dx, dy in [(0,1),(1,0),(0,-1),(-1,0)]:
                nx, ny = x, y
                # roll until hitting wall
                while 0 <= nx + dx < m and 0 <= ny + dy < n and maze[nx + dx][ny + dy] == 0:
                    nx += dx
                    ny += dy
                if dfs(nx, ny):
                    return True
            return False
        
        return dfs(start[0], start[1])