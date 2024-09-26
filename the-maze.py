"""
# Problem2 The Maze (https://leetcode.com/problems/the-maze/)

There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.



Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true

Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0

0 0 0 0 0

0 0 0 1 0

1 1 0 1 1

0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)

Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false

Explanation: There is no way for the ball to stop at the destination.



Note:

There is only one ball and one destination in the maze.

Both the ball and the destination exist on an empty space, and they will not be at the same position initially.

The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.

The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

time - O(mn)
SPACE- O(mn)
"""
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None or len(maze) ==0:
            return
        directions = [[0,1],[1,0],[-1,0],[0,-1]]
        q = deque()
        q.append((start[0],start[[1]]))
        maze[start[0]][start[1]]=2  #marked visited
        while q:
            front = q.popleft()
            if front[0]==destination[0] and front[1]==destination[1]:
                return True
            for direct in directions:
                i = front[0]
                j= front[1]
                while i >=0 and i < len(maze) and j >=0 and j <len(maze[0]) and maze[i][j]!=1:  # checking 4 directions
                    i += direct[0]
                    j += direct[0]
                i -=direct[0]
                j -=direct[1]

                if maze[i][j] !=2:       # if not visited
                    q.append((i,j))    # add to queue
                    maze[i][j] =2 # mark it visited
        return False

