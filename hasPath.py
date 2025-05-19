from collections import deque

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        """
        Approach:
        1. Use BFS to simulate a ball rolling in a maze.
        2. From each cell, roll the ball in all 4 directions until it hits a wall (1) or boundary.
        3. Track visited stopping points using a set to avoid cycles.
        4. If the destination is reached, return True. Otherwise, continue BFS until queue is empty.

        Time Complexity: O(m * n) — In the worst case, each cell can be visited once.
        Space Complexity: O(m * n) — For the visited set and queue.

        Where:
        - m = number of rows in the maze
        - n = number of columns in the maze
        """
        rows, cols = len(maze), len(maze[0])
        visited = set()
        queue = deque([tuple(start)])

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # up, down, left, right

        while queue:
            x, y = queue.popleft()

            if [x, y] == destination:
                return True

            if (x, y) in visited:
                continue
            visited.add((x, y))

            for dx, dy in directions:
                nx, ny = x, y
                # Roll in one direction until hitting a wall or boundary
                while 0 <= nx + dx < rows and 0 <= ny + dy < cols and maze[nx + dx][ny + dy] == 0:
                    nx += dx
                    ny += dy
                queue.append((nx, ny))

        return False
