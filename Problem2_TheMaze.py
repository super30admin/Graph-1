# Time Complexity: O((mn)(m+n)), where m - num of rows and n - num of cols
# Space Complexity: O(mn)

# BFS
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or len(maze) == 0:
            return False

        rows = len(maze)
        cols = len(maze[0])

        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        q = deque([start])

        while q:
            curr = q.popleft()

            # Explore all four directions
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]

                # Move forward until the ball hits a brick or the wall
                while 0 <= r < rows and 0 <= c < cols and maze[r][c] != 1:
                    r += d[0]
                    c += d[1]

                r -= d[0]
                c -= d[1]

                # If destination is reached, return true
                if [r, c] == destination:
                    return True

                # Mark the cell visited and append to the queue
                if maze[r][c] != 2:
                    maze[r][c] = 2
                    q.append([r, c])

        return False


# DFS
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or len(maze) == 0:
            return False

        self.rows = len(maze)
        self.cols = len(maze[0])
        self.dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        return self.dfs(maze, start, destination)

    def dfs(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # base
        if start == destination:
            return True

        # Mark visited
        maze[start[0]][start[1]] = 2

        for d in self.dirs:
            r = start[0] + d[0]
            c = start[1] + d[1]

            # Reach until it hits the wall or brick
            while 0 <= r < self.rows and 0 <= c < self.cols and maze[r][c] != 1:
                r += d[0]
                c += d[1]

            r -= d[0]
            c -= d[1]

            # Recurse from this cell as the start point
            if maze[r][c] != 2 and self.dfs(maze, [r, c], destination):
                return True

        return False
