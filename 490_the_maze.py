"""
Leetcode: https://leetcode.com/problems/the-maze/

Approach: DFS using stack
To explore the search space by rolling the ball into all stopping positions, while also keeping track of already visited positions so that we do not repeat our paths.

Time complexity : O(mn). Complete traversal of maze will be done in the worst case. Here, m and n refers to the number of rows and columns of the maze.
Space complexity : O(mn). visited array of size m∗n is used.
"""

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        rows = len(maze)
        cols = len(maze[0])

        # Set to keep track of previously stopped positions
        seen = set()
        # Stack keeping track of stopped points
        stack = [start]

        # Utility function to move ball in a direction until we hit a wall
        def move(i, j, ichange, jchange):
            nonlocal maze, rows, cols
            # ci and cj are the resultant locations and are used to keep i, j as original value
            ci, cj = i, j
            # While moving ball gives a valid location, keep moving ball
            while 0 <= ci+ichange < rows and 0 <= cj+jchange < cols and maze[ci+ichange][cj+jchange] == 0:
                ci += ichange
                cj += jchange
            # Return the resultant location
            return ci, cj

        # Translating each possible movement into changes in i, j values
        DIRECTIONS = [
            [0, -1],    # left
            [0, +1],    # right
            [-1, 0],    # up
            [+1, 0],    # down
        ]

        # While we have valid stop positions for ball
        while stack:
            # If the stop position was already seen, ignore it and try the next one
            i, j = stack.pop()
            if (i,j) in seen:
                continue

            # Set this stop position as explored
            seen.add((i,j))

            # For each possible direction, try to move ball
            for direction in DIRECTIONS:
                movedi, movedj = move(i, j, *direction)
                # If result is the destination, the maze is solvable
                if destination == [movedi, movedj]:
                    return True
                # Otherwise add the stopping point to be explored further
                stack.append([movedi, movedj])

        # We went through all possible stop positions and still didn't reach the destination
        # Therefore maze is not solvable
        return False