# Time Complexity : O(m*n)
# Space Complexity: O(m*n)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze is None or len(maze) == 0:
            return 0

        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.m = len(maze)
        self.n = len(maze[0])

        return self.helper(maze, start, destination)

    def helper(self, maze, start, destination):
        # base case
        if start[0] == destination[0] and start[1] == destination[1]:
            return True

        if maze[start[0]][start[1]] == 2:
            return False

        # logic
        maze[start[0]][start[1]] = 2

        for dir in self.dirs:
            i = start[0]
            j = start[1]

            while i < self.m and j < self.n and i >= 0 and j >= 0 and maze[i][j] != 1 :
                i += dir[0]
                j += dir[1]

            i -= dir[0]
            j -= dir[1]

            if maze[i][j] != 2 and self.helper(maze, [i, j], destination):
                return True

        return False
