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

Discussion on Time Complexity:
MN = extreme case when there too many hurdles ("while q" loop which is the outer loop)
max(M,N) = extreme case when there are no hurdles and the ball moves from wall to wall w/o obstruction ("while maze[x][y] != 1" loop which is the inner loop)
Hence, total TC = MN * max(M,N)

But this is incorrect because when there are more hurdles (TC of outer loop increases), the ball makes fewer moves between walls (TC of inner loop decreases). And vice-versa.

Hence, the two terms, MN and max(M,N), compete against each other resulting in
O(max(MN, max(M,N)) = O(max(MN, M+N)) = O(MN)

Time: O(MN), Space: O(MN)
https://youtu.be/M8AX7QvCtsg?t=600 (RS)
https://youtu.be/XJKdD8CnGvI?t=1302 (JS, note the important point: nodes that are queued are not just neighbors of the starting node but the nodes where
the ball stops after rolling from the start node)
https://youtu.be/XJKdD8CnGvI?t=2856 (Discussion on TC)

2. DFS
We use BFS to reach the destination. This is similar to the BFS approach.
Instead of enqueuing the cell using q.append(cell) in BFS, we call the recurse function.
Time: O(MN), Space: O(MN) (space is due to recursive stack)
https://youtu.be/M8AX7QvCtsg?t=1943

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

        for dir in dirs:
            x, y = curr[0] + dir[0], curr[1] + dir[1]

            # Go all the way to a wall O(max(M,N))
            while 0 <= x <= M-1 and 0 <= y <= N-1 and maze[x][y] != 1:
                x, y = x + dir[0], y + dir[1]

            # undo the last step since we go out of bounds in the last step
            x, y = x - dir[0], y - dir[1]

            # add the cell to queue only after we have hit a wall and it has
            # not been visited
            if maze[x][y] != 2:
                q.append([x, y])
                maze[x][y] = 2 # mark as visited
    return reached


def hasPath_dfs(maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
    def dfs(maze, curr):
        nonlocal reached
        # base
        if curr == destination:
            return True

        if reached:
            return True

        for dir in dirs:
            x, y = curr[0] + dir[0], curr[1] + dir[1]
            while  0<=x<=M-1 and 0<=y<=N-1 and maze[x][y] != 1:
                x, y = x + dir[0], y + dir[1]
            x, y = x - dir[0], y - dir[1]
            if maze[x][y] != 2:
                maze[x][y] = 2
                source = [x, y]
                reached = dfs(maze, source)
                if reached:
                    break
        return reached

    M = len(maze)
    N = len(maze[0])
    dirs = [[-1,0],[1,0],[0,-1],[0,1]] # U, D, L, R
    maze[start[0]][start[1]] = 2 # special no. to avoid calling dfs a 2nd time for this cell
    # logic
    reached = False
    reached = dfs(maze, start)
    return reached

def run_tests():
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
            passed = (ans == reached)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()