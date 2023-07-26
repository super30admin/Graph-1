from collections import deque


class Solution:
    def hasPath(self, maze, start, destination):
        """
        Time complexity - O(mn), m --> rows, and n --> columns in the maze.
        Space complexity - O(mn)

        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        if not maze:
            return False

        # Get the number of rows and columns in the maze.
        m, n = len(maze), len(maze[0])

        queue = deque()  # Create a deque (queue) to perform BFS.
        # Directions: up, down, left, right.
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        queue.append(start)  # Add the start point to the queue.
        maze[start[0]][start[1]] = 2  # Mark the start point as visited.

        while queue:
            i, j = queue.popleft()  # Get the current position from the queue.

            for di, dj in directions:  # Check all four directions.
                x, y = i, j

                # Move in the current direction until hitting a wall or out of bounds.
                while 0 <= x + di < m and 0 <= y + dj < n and maze[x + di][y + dj] != 1:
                    x += di
                    y += dj

                if maze[x][y] != 2:  # If the new position is not visited:
                    if [x, y] == destination:
                        return True  # Check if it's the destination.
                    queue.append([x, y])  # Add the new position to the queue.
                    maze[x][y] = 2  # Mark the new position as visited.

        # If no path found after exploring all possible paths, return False.
        return False
