# Problem2 The Maze (https://leetcode.com/problems/the-maze/)
# Time Complexity: O(m * n * max(m, n)),Each cell can be visited once as a "stopping point" -> O(m*n) DFS calls.From each stopping point, we roll in 4 directions, each roll can take up to O(max(m,n)) steps
# Space Complexity: O(m * n),Recursion stack in the worst case can hold O(m*n) calls(the maze itself is reused as the visited array, so no extra visited grid is needed)
# Approach:
# The ball doesn't stop cell by cell, it rolls until it hits a wall or the border.
# So from each position, roll in all 4 directions until blocked, and only stop there.
# Treat each "stopping point" as a node, and DFS between stopping points.
# Mark visited stopping points as -1 in the maze to avoid revisiting the same paths.

class Solution:
    def hasPath(self, maze, start, destination):
        self.dirs = [(1,0),(0,1),(0,-1),(-1,0)]   # down, right, left, up
        self.m = len(maze)                         # number of rows
        self.n = len(maze[0])                       # number of columns

        return self.dfs(maze, start[0], start[1], destination)

    def dfs(self, maze, i, j, destination):
        # base case 1: reached the destination
        if destination[0] == i and destination[1] == j:
            return True

        # base case 2: already visited this stopping point, avoid infinite loop
        if maze[i][j] == -1:
            return False

        maze[i][j] = -1   # mark current stopping point as visited

        for dir in self.dirs:
            r = dir[0] + i   # take one step in this direction
            c = dir[1] + j

            # keep rolling while still inside the maze and not hitting a wall
            while r >= 0 and c >= 0 and r < self.m and c < self.n and maze[r][c] != 1:
                r += dir[0]
                c += dir[1]

            # the loop above overshoots by one step (lands on wall/border), so step back
            r -= dir[0]
            c -= dir[1]

            # recursively check if the destination is reachable from this new stopping point
            if self.dfs(maze, r, c, destination):
                return True

        return False   # no direction led to the destination