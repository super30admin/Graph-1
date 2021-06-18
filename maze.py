from collections import deque


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze is None or len(maze) == 0 or len(maze[0]) == 0: return False
        row, column = len(maze), len(maze[0])
        queue = deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2
        direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        while queue.__len__() > 0:
            size = queue.__len__()
            # for di in range(size):
            mazespacec = queue.popleft()
            for nextmove in direction:
                rowindex = mazespacec[0]
                columnindex = mazespacec[1]
                while rowindex >= 0 and rowindex < row and columnindex >= 0 and columnindex < column and maze[rowindex][
                    columnindex] != 1:
                    rowindex = rowindex + nextmove[0]
                    columnindex = columnindex + nextmove[1]
                rowindex = rowindex - nextmove[0]
                columnindex = columnindex - nextmove[1]
                if rowindex == destination[0] and columnindex == destination[1]: return True
                if maze[rowindex][columnindex] != 2:
                    maze[rowindex][columnindex] = 2
                    queue.append([rowindex, columnindex])
        return False


#time:- O(m*n)(m+n)

from collections import deque


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze is None or len(maze) == 0 or len(maze[0]) == 0: return False
        self.m, self.n = len(maze), len(maze[0])

        return self.dfs(maze, start, destination)

    def dfs(self, maze, start, destination):
        if start[0] == destination[0] and start[1] == destination[1]: return True

        maze[start[0]][start[1]] = 2

        dirs = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        for i in dirs:
            r = i[0] + start[0]
            c = i[1] + start[1]
            while r < self.m and c < self.n and r >= 0 and c >= 0 and maze[r][c] != 1:
                r += i[0]
                c += i[1]
            r = r - i[0]
            c = c - i[1]
            if maze[r][c] != 2 and self.dfs(maze, [r, c], destination):
                return True
        return False








