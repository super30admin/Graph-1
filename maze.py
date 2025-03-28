"""
DFS Approach --
TC - K(m * n) where K is the max number of directions we travel in, i.e. 4 directions
SC - O(m * n)
"""
from collections import deque


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None or len(maze) == 0: return False

        self.m = len(maze)
        self.n = len(maze[0])
        # U D L R
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

        return self.dfs(maze, start, destination)

    def dfs(self, maze, start, destination):
        # base
        if start[0] == destination[0] and start[1] == destination[1]:
            return True

        # logic
        maze[start[0]][start[1]] = -1
        i = 0
        j = 0
        for _dir in self.dirs:
            i = i + start[0]
            j = j + start[1]

            # set boundry conditions
            while i >= 0 and j >= 0 and i < self.m and j < self.n and maze[i][j] != 1:
                i = i + _dir[0]
                j = j + _dir[1]

            # take one step back once we hit the boundry condition
            i = i - _dir[0]
            j = j - _dir[1]

            if (maze[i][j] == -1 and self.dfs(maze, [i, j], destination)):
                return True

        return False