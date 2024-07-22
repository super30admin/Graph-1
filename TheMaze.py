# Time Complexity : O(mxn)(m+n), where mxn is the size of the maze
# Space Complexity : O(mxn)

from collections import deque

class Solution:
    def hasPath(self, maze, start, destination):
        # Define the four directions: right, down, left, up
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        # Initialize a queue with the start position
        q = deque([(start[0], start[1])])
        
        # Mark the start position as visited by setting it to 2
        maze[start[0]][start[1]] = 2
        
        # Perform BFS
        while q:
            # Get the current position
            i, j = q.popleft()
            
            # Explore all four directions
            for dir in dirs:
                x, y = i, j
                
                # Keep moving in the current direction until hitting a wall
                while self.isValid(maze, x + dir[0], y + dir[1]):
                    x += dir[0]
                    y += dir[1]
                
                # If the destination is reached, return True
                if (x, y) == (destination[0], destination[1]):
                    return True
                
                # If the current position has been visited before, skip it
                if maze[x][y] == 2:
                    continue
                
                # Add the current position to the queue and mark it as visited
                q.append((x, y))
                maze[x][y] = 2
        
        # If all possible paths are exhausted without reaching the destination, return False
        return False

    # Helper function to check if a position is valid (within the maze and not a wall)
    def isValid(self, maze, x, y):
        return 0 <= x < len(maze) and 0 <= y < len(maze[0]) and maze[x][y] != 1

# Examples
sol = Solution()

# Example 1
maze1 = [
    [0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0],
    [1, 1, 0, 1, 1],
    [0, 0, 0, 0, 0]
]
start1 = [0, 4]
destination1 = [4, 4]
print("Example 1:", sol.hasPath(maze1, start1, destination1))  # Output: True

# Example 2
maze2 = [
    [0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0],
    [1, 1, 0, 1, 1],
    [0, 0, 0, 0, 0]
]
start2 = [0, 4]
destination2 = [3, 2]
print("Example 2:", sol.hasPath(maze2, start2, destination2))  # Output: False

# Example 3
maze3 = [
    [0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0],
    [1, 1, 0, 1, 1],
    [0, 0, 0, 0, 0]
]
start3 = [4, 3]
destination3 = [0, 1]
print("Example 3:", sol.hasPath(maze3, start3, destination3))  # Output: False
