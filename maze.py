# Time O(MN)
# Space O(MN)

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # Approach 1
        def helper(i, j):
            # Base
            # if i not in range(len(maze)) or j not in range(len(maze[0])): return False
            if [i, j] == destination:
                return True
            if maze[i][j] == 2:
                return False
            # print(i, j)
            # Logic
            maze[i][j] = 2
            for dire in dirs:
                x = i
                y = j
                while x >= 0 and y >= 0 and x < len(maze) and y < len(maze[0]) and maze[x][y] != 1:
                    x += dire[0]
                    y += dire[1]
                x -= dire[0]
                y -= dire[1]
                if helper(x, y):
                    return True
            return False

        dirs = [[0, -1], [-1, 0], [1, 0], [0, 1]]
        return helper(start[0], start[1])

        # Approach 2
        if start == destination:
            return True
        dirs = [[0, -1], [-1, 0], [1, 0], [0, 1]]
        visited = set()

        q = deque()
        q.append(start)
        while q:
            curr = q.popleft()
            for dire in dirs:
                i = curr[0]
                j = curr[1]
                while i >= 0 and i < len(maze) and j >= 0 and j < len(maze[0]) and maze[i][j] != 1:
                    i += dire[0]
                    j += dire[1]

                i -= dire[0]
                j -= dire[1]
                if [i, j] == destination:
                    return True
                if maze[i][j] != 2:
                    maze[i][j] = 2
                    q.append([i, j])
        return False
