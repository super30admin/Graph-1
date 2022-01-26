# BFS Approach
class Solution:
    # Time Complexity - O(m*n*max(m,n))
    # Space Complexity - O(m*n) for the queue
    def hasPath(self, maze, start, destination) -> bool:
        if maze is None or len(maze) == 0: return False
        q = []
        m = len(maze)
        n = len(maze[0])
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        q.append(start)
        maze[start[0]][start[1]] = 2
        while q:
            curr = q.pop(0)
            for direction in dirs:
                i = curr[0]
                j = curr[1]
                while (i < m) and (j < n) and  i>=0 and j>=0 and maze[i][j] != 1:
                    i = i + direction[0]
                    j = j + direction[1]
                # To move one element beside '1'
                i = i - direction[0]
                j = j - direction[1]
                if i == destination[0] and j == destination[1]:\
                    return True
                if maze[i][j] == 0:
                    maze[i][j] = 2
                    q.append([i,j])
        return False

# DFS Approach
class Solution:
    # Time Complexity - O(m*n*max(m,n))
    # Space Complexity - O(m*n) for the queue
    def hasPath(self, maze, start, destination) -> bool:
        if maze is None or len(maze) == 0: return False
        q = []
        m = len(maze)
        n = len(maze[0])
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

        def dfs(maze, start, destination):
            # Base
            if start[0] == destination[0] and start[1] == destination[1]:
                return True
            if maze[start[0]][start[1]] == 2:
                return False

            # Logic
            maze[start[0]][start[1]] = 2
            for direction in dirs:
                i = start[0]
                j = start[1]
                while (i < m and j < n and i >= 0 and j >= 0 and maze[i][j] != 1):
                    i = i + direction[0]
                    j = j + direction[1]
                i = i - direction[0]
                j = j - direction[1]

                if maze[i][j] != 2 and dfs(maze, [i, j], destination):
                    return True
            return False

        return dfs(maze, start, destination)