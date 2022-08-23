'''

## Problem 490: The maze

## Author: Neha Doiphode
## Date:   08-22-2022

## Description:
    There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1).
    The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
    When the ball stops, it could choose the next direction.

    Given the m x n maze, the ball's start position and the destination,
    where start = [startrow, startcol] and destination = [destinationrow, destinationcol],
    return true if the ball can stop at the destination, otherwise return false.

    You may assume that the borders of the maze are all walls (see examples).

## Examples:
    Example 1:
        Input: maze = [[0,0,1,0,0],
                       [0,0,0,0,0],
                       [0,0,0,1,0],
                       [1,1,0,1,1],
                       [0,0,0,0,0]], start = [0,4], destination = [4,4]
        Output: true
        Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

    Example 2:
        Input: maze = [[0,0,1,0,0],
                       [0,0,0,0,0],
                       [0,0,0,1,0],
                       [1,1,0,1,1],
                       [0,0,0,0,0]], start = [0,4], destination = [3,2]
        Output: false
        Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.

    Example 3:
        Input: maze = [[0,0,0,0,0],
                       [1,1,0,0,1],
                       [0,0,0,0,0],
                       [0,1,0,0,1],
                       [0,1,0,0,0]], start = [4,3], destination = [0,1]
        Output: false


 ## Constraints:
    m == maze.length
    n == maze[i].length
    1 <= m, n <= 100
    maze[i][j] is 0 or 1.
    start.length == 2
    destination.length == 2
    0 <= startrow, destinationrow <= m
    0 <= startcol, destinationcol <= n
    Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
    The maze contains at least 2 empty spaces.


## Time complexity : Please refer to doc-strings of respective approaches used below.

## Space complexity: Please refer to doc-strings of respective approaches used below.

'''

from typing import List, Optional
from collections import deque

def get_input():
    print("Enter the number of rows on the maze: ", end = "")
    rows = int(input())
    print("Enter the number of columns on the maze: ", end = "")
    columns = int(input())
    maze = []
    for row in range(rows):
        l = []
        print(f"Row {row + 1}: ")
        for column in range(columns):
            inp = int(input())
            l.append(inp)
        maze.append(l)
    print("Enter the start cell coordinates(row_number <space> column_number): ", end = "")
    start = input()
    start = [int(val) for val in start.split()]
    print("Enter the destination cell coordinates(row_number <space> column_number): ", end = "")
    destination = input()
    destination = [int(val) for val in destination.split()]
    return maze, start, destination


class Solution:
    directions = []
    def hasPath_bfs(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        '''
        Approach: We are using BFS as we have connected components in the problem.
                  where the decision for a cell depends on the connected neighbors.

        Time complexity : O(m * n * max(m, n)),
                          At every cell we go in 4 directions to find out neighboring cells as visited or not visited.
        Space complexity: O(m * n), as all cells can be 0s.
        '''
        if len(maze) == 0:
            return False

                # Up, Down, Left, Right
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

        # Number of rows on the maze
        rows = len(maze)
        columns = len(maze[0])

        # Declare a queue to be used for BFS
        q = deque()
        q.append(start)
        # Make start cell 2 to mark it visited
        maze[start[0]][start[1]] = 2

        # Now start processing the queue
        while len(q) != 0:
            current_cell = q.popleft()
            # Go thru the direction and process current cell
            for dir in dirs:
                nr = current_cell[0]
                nc = current_cell[1]
                # Keep going in the current direction until we find a blocking cell or a visited cell in that direction
                # Also we make sure that we check boundary conditions of the maze.
                while nr >= 0 and nr < rows and nc >=0 and nc < columns and maze[nr][nc] != 1:
                    nr += dir[0]
                    nc += dir[1]

                # Since we brok the while loop, we need to get the cell back within bounds.
                # So we have to undo the last action
                nr -= dir[0]
                nc -= dir[1]

                # Now check if the cell is 0
                if maze[nr][nc] == 0:
                    if nr == destination[0] and nc == destination[1]:
                        return True
                    maze[nr][nc] = 2
                    q.append([nr, nc])

        return False


    def dfs(self, maze, current, destination, rows, columns):
        # base
        if current[0] == destination[0] and current[1] == destination[1]:
            return True

        # logic
        maze[current[0]][current[1]] = 2
        for dir in self.directions:
            nr = current[0] + dir[0]
            nc = current[1] + dir[1]
            while nr >= 0 and nr < rows and nc >= 0 and nc < columns and maze[nr][nc] != 1:
                nr += dir[0]
                nc += dir[1]

            nr -= dir[0]
            nc -= dir[1]
            if maze[nr][nc] != 2 and self.dfs(maze, [nr, nc], destination, rows, columns):
                return True
        return False

    def hasPath_dfs(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        '''
        Time complexity : O(m * n * max(m, n)),
                          At every cell we go in 4 directions to find out neighboring cells as visited or not visited.
        Space complexity: O(m * n), as all cells can be 0s.
        '''
        if len(maze) == 0:
            return False

                # Up, Down, Left, Right
        self.directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]

        rows = len(maze)
        columns = len(maze[0])

        current = start
        return self.dfs(maze, current, destination, rows, columns)

# Driver code
solution = Solution()
maze, start, destination = get_input()
print(f"Input maze: {maze}")
print(f"Approach 1: Using BFS: Does path from start to destination exist? : {solution.hasPath_bfs(maze, start, destination)}")
print(f"Approach 2: Using DFS: Does path from start to destination exist? : {solution.hasPath_dfs(maze, start, destination)}")
