# 490. The Maze
from typing import List
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        q = deque([])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]

        q.append((start[0],start[1]))
        maze[start[0]][start[1]] = 2
        
        if start[0] == destination[0] and start[1] == destination[1]: return True

        while q:
            curr = q.popleft()

            for dir_ in dirs:
                r = dir_[0] + curr[0]
                c = dir_[1] + curr[1]

                if 0 <= r < m and 0 <= c < n and maze[r][c] != 1:
                    while 0 <= r < m and 0 <= c < n and maze[r][c] != 1:
                        r += dir_[0]
                        c += dir_[1]

                    r -= dir_[0]
                    c -= dir_[1]

                    if r == destination[0] and c == destination[1]: return True
                    if maze[r][c] != 2:
                        q.append((r,c))
                        maze[r][c] = 2
        return False
            



