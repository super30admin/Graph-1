# Time complexity: O(rows * columns * max(rows, columns))
# Space complexity: O(rows * columns)
from collections import deque
from typing import List

class Solution:

    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze:
            return False

        if start[0] == destination[0] and start[1] == destination[1]:
            return True

        q = deque()  # Create a deque to store positions to explore
        rows = len(maze)
        columns = len(maze[0])
        q.appendleft(start)  # Add the start position to the deque
        maze[start[0]][start[1]] = 2  # Mark the start position as visited (2)
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # Directions to move (up, down, left, right)

        while q:  # While there are positions to explore in the deque
            curr = q.pop()  # Get the next position to explore from the right end of the deque
            for dir in dirs:  # Try moving in each direction
                curr_row = curr[0]  # Get the current row index
                curr_col = curr[1]  # Get the current column index
                while 0 <= curr_row + dir[0] < rows and 0 <= curr_col + dir[1] < columns and maze[curr_row + dir[0]][curr_col + dir[1]] != 1:
                    # Move in the current direction until the next position is within the maze and not a wall (1)
                    curr_row += dir[0]  # Update the row index
                    curr_col += dir[1]  # Update the column index

                if maze[curr_row][curr_col] != 2:  # If the destination has not been visited yet
                    if curr_row == destination[0] and curr_col == destination[1]:  # If the destination is reached
                        return True  # Return True, a path exists
                    q.appendleft([curr_row, curr_col])  # Add the next position to explore to the left end of the deque
                    maze[curr_row][curr_col] = 2  # Mark the next position as visited (2)

        return False  # Return False, no path was found to the destination
