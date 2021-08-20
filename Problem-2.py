class Solution:
    def hasPath(self, maze, start, destination) :

        if maze == None or len(maze) == 0:
            return False

        m = len(maze)
        n = len(maze[0])

        return self.dfs(maze, start, destination, m, n)

    def dfs(self, maze, start, destination, m, n):

        # base
        if start[0] == destination[0] and start[1] == destination[1]:
            return True

        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        # logic
        maze[start[0]][start[1]] = 2
        for dir in dirs:
            i = start[0]
            j = start[1]
            while i < m and j < n and i >= 0 and j >= 0 and maze[i][j] != 1:
                i += dir[0]
                j += dir[1]

            i -= dir[0]
            j -= dir[1]

            if maze[i][j] != 2 and self.dfs(maze, (i, j), destination, m, m):
                return True

        return False


