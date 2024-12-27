# Explain your approach briefly at the top:
# Use a Depth First Search (DFS) or Breadth First Search (BFS) to explore the maze.
# The ball rolls in one direction until it hits a wall. At each stop, recursively or iteratively explore new directions.
# Use a visited set to avoid processing the same position multiple times.
# If the destination is reached during exploration, return True. Otherwise, return False after all possibilities are explored.

# Time Complexity: O(m * n), where m and n are the dimensions of the maze, as each cell can be visited once.
# Space Complexity: O(m * n) for the visited set and recursion stack or queue storage.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        def is_valid(x, y):
            # Check if the position is within bounds and not a wall
            return 0 <= x < m and 0 <= y < n and maze[x][y] == 0
        
        def dfs(x, y):
            # If this position is already visited, skip
            if (x, y) in visited:
                return False
            # Mark the current position as visited
            visited.add((x, y))
            # If the current position is the destination, return True
            if [x, y] == destination:
                return True
            # Explore all four directions
            for dx, dy in directions:
                nx, ny = x, y
                # Roll the ball in the current direction until it hits a wall
                while is_valid(nx + dx, ny + dy):
                    nx += dx
                    ny += dy
                # Call DFS from the stopping position
                if dfs(nx, ny):
                    return True
            return False
        
        m, n = len(maze), len(maze[0])  # Dimensions of the maze
        visited = set()  # Set to keep track of visited positions
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # Directions: right, down, left, up
        
        # Start DFS from the initial position
        return dfs(start[0], start[1])
