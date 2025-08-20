'''
490 The Maze
https://leetcode.com/problems/the-maze/description/

There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).

Example 1:
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
Output: false
Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.

Example 3:
Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
Output: false

Constraints:
m == maze.length
n == maze[i].length
1 <= m, n <= 100
maze[i][j] is 0 or 1.
start.length == 2
destination.length == 2
0 <= startrow, destinationrow < m
0 <= startcol, destinationcol < n
Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
The maze contains at least 2 empty spaces.

Solution:
1. BFS
We use BFS to reach the destination. From a given cell, once the ball starts rolling in a specific direction, it doesn't stop rolling until it has hit a wall or hit the destination. Once it stops, we check if that position is the destination; if not visited, we enqueue it. We mark visited positions in-place by setting them to 2 to avoid cycles.

https://youtu.be/M8AX7QvCtsg?t=600
Time: O(MN * max(M,N)), Space: O(MN) (max(M,N) is due to the inner while loop which takes the ball to a wall)

2. DFS
We use BFS to reach the destination. This is similar to the BFS approach.
Instead of enqueuing the cell using q.append(cell) in BFS, we call the recurse function.
https://youtu.be/M8AX7QvCtsg?t=1943
Time: O(MN * max(M,N)), Space: O(MN) (space is due to recursive stack)
'''
from typing import List
from collections import deque
from copy import deepcopy as dcp

def hasPath_bfs(maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
    M = len(maze)
    N = len(maze[0])
    dirs = [[-1,0],[1,0],[0,-1],[0,1]] # U, D, L, R
    q = deque()
    q.append(start)
    maze[start[0]][start[1]] = 2 # special no. to avoid queuing it a 2nd time
    reached = False
    while q:
        curr = q.popleft()
        if curr == destination:
            reached = True
            break
        #print(f"curr: maze[{curr[0]}][{curr[1]}] = {maze[curr[0]][curr[1]]}")
        for dir in dirs:
            x, y = curr[0] + dir[0], curr[1] + dir[1]

            # Go all the way to a wall
            while  0<=x<=M-1 and 0<=y<=N-1 and maze[x][y] != 1:
                x, y = x + dir[0], y + dir[1]

            # At this point, x,y may be out of bounds or in a cell where maze[x][y] = 1. Hence, undo the last step
            x, y = x - dir[0], y - dir[1] # place back to the grid

            #print(f"nbr: maze[{x}][{y}] = {maze[x][y]}")
            # Add cell to queue if it has not been already added
            if maze[x][y] != 2: # check if cell hasn't been added to q
                q.append([x,y])
                maze[x][y] = 2
                #print(f"change: maze[{x}][{y}] = {maze[x][y]}")
    return reached

def hasPath_dfs(maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
    def dfs(maze, curr, destination):
        # base
        if curr == destination:
            return True

        # logic
        reached = False
        for dir in dirs:
            x, y = curr[0] + dir[0], curr[1] + dir[1]
            while  0<=x<=M-1 and 0<=y<=N-1 and maze[x][y] != 1:
                x, y = x + dir[0], y + dir[1]
            x, y = x - dir[0], y - dir[1]
            if maze[x][y] != 2:
                maze[x][y] = 2
                source = [x, y]
                reached = dfs(maze, source, destination)
                if reached:
                    break
        return reached

    M = len(maze)
    N = len(maze[0])
    dirs = [[-1,0],[1,0],[0,-1],[0,1]] # U, D, L, R
    maze[start[0]][start[1]] = 2 # special no. to avoid calling dfs a 2nd time for this cell
    reached = dfs(maze, start, destination)
    return reached

def run_hasPath():
    tests = [([ [0,0,1,0,0],
                [0,0,0,0,0],
                [0,0,0,1,0],
                [1,1,0,1,1],
                [0,0,0,0,0],
              ], [0,4], [4,4], True),
             ([ [0,0,1,0,0],
                [0,0,0,0,0],
                [0,0,0,1,0],
                [1,1,0,1,1],
                [0,0,0,0,0],
              ], [0,4], [3,2], False),
             ([ [0,0,0,0,0],
                [1,1,0,0,1],
                [0,0,0,0,0],
                [0,1,0,0,1],
                [0,1,0,0,0],
              ], [4,3], [0,1], False),
    ]

    for test in tests:
        maze, start, destination, ans = test[0], test[1], test[2], test[3]
        print(f"\nMaze = {maze}")
        print(f"Start cell = {start}")
        print(f"Destination cell = {destination}")
        for method in ['bfs', 'dfs']:
            if method == 'bfs':
                reached = hasPath_bfs(dcp(maze), start, destination)
            elif method == 'dfs':
                reached = hasPath_dfs(dcp(maze), start, destination)
            print(f"Method {method}: Reached destination = {reached}")
            success = (ans == reached)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_hasPath()