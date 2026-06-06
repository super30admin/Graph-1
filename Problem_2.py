# class Solution:
#     def hasPath(
#         self, maze, start, destination):
#         directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
#         return self.dfs(
#             start[0], start[1], destination[0], destination[1], maze, directions
#         )

#     def dfs(self, cr, cc, dr, dc, maze, directions):
#         if cr == dr and cc == dc:
#             return True
#         if maze[cr][cc] == 2:
#             return False
#         maze[cr][cc] = 2
#         for r, c in directions:
#             nr, nc = cr + r, cc + c
#             while 0 <= nr < len(maze) and 0 <= nc < len(maze[0]) and maze[nr][nc] != 1:
#                 nr, nc = nr + r, nc + c
#             nr, nc = nr - r, nc - c
#             if self.dfs(nr, nc, dr, dc, maze, directions):
#                 return True
#         return False


from collections import deque


class Solution:
    def hasPath(
        self, maze,start, destination):
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        q = deque([start])
        while q:
            curr = q.popleft()
            cr, cc = curr[0], curr[1]
            if cr == destination[0] and cc == destination[1]:
                return True
            maze[cr][cc] = 2
            for r, c in directions:
                nr, nc = cr + r, cc + c
                while (
                    0 <= nr < len(maze) and 0 <= nc < len(maze[0]) and maze[nr][nc] != 1
                ):
                    nr, nc = nr + r, nc + c
                nr, nc = nr - r, nc - c
                if maze[nr][nc] != 2:
                    q.append([nr, nc])
        return False
