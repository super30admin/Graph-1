'''
TC: O((m*n)*(m+n)) where m and n are ROWS and COLS respectively.
    m*n cause we go through every space to find the possible neighbors
    m+n ~ O(max(m,n)) depending upon the banners either m or n decreases accordingly.
            To go in different directions
SC: O(m*n) the space occupied by the queue
'''
from collections import deque
from typing import List

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #BFS
        ROWS, COLS = len(maze), len(maze[0])

        q = deque()
        q.append(start)
        maze[start[0]][start[1]] = 2
        while q:
            x,y = q.popleft()
            dirs = [(0,1),(1,0),(0,-1),(-1,0)]
            for dir_ in dirs:
                nx,ny = x+dir_[0], y+dir_[1]
                while (nx>=0 and ny>=0 and nx<ROWS and ny<COLS and maze[nx][ny]!=1):
                    nx,ny = nx+dir_[0], ny+dir_[1]
                nx,ny = nx-dir_[0], ny-dir_[1]
                if maze[nx][ny]!=2:
                    q.append([nx,ny])
                    maze[nx][ny] = 2
                if [nx,ny] == destination:
                    return True
        return False
s = Solution()
print(s.hasPath([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], [0,4], [4,4]))
print(s.hasPath([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], [0,4], [3,2]))
print(s.hasPath([[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], [4,3], [0,1]))